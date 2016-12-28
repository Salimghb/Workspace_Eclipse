using System;
using System.Collections.Generic;
using System.Text;
using Nikoui.PokCommons;
using Nikoui.PokStats.Properties;

namespace Nikoui.PokStats.Combinations
{
    /// <summary>
    /// Flush card combination.
    /// Flush is reached when at least five cards of the same family are found.
    /// </summary>
    public class FlushCombination
        : Combination
    {
        /// <summary>
        /// Get the name of the combination.
        /// </summary>
        public override string Name
        {
            get 
            {
                return (Resources.Flush);
            }
        }

        /// <summary>
        /// Get the weight of the combination.
        /// Weight allow to compare combination values.
        /// </summary>
        public override byte Weight
        {
            get
            {
                return (4);
            }
        }

        /// <summary>
        /// Check if the combination is reached.
        /// </summary>
        /// <returns><c>true</c> if combination is reached, <c>false</c> otherwise.</returns>
        protected override bool ComputeReached()
        {
            bool result = false;
            if (SeenCards != null && SeenCards.Count >= 5)
            {
                // List cards by families
                Dictionary<CardFamilies, List<Card>> cards = new Dictionary<CardFamilies, List<Card>>();
                foreach (Card card in SeenCards)
                {
                    if (!cards.ContainsKey(card.Family))
                    {
                        // First card of this family
                        cards.Add(card.Family, new List<Card>());
                    }
                    cards[card.Family].Add(card);
                }
                // Look for 5 or more cards of the same family
                foreach (CardFamilies cardFamily in cards.Keys)
                {
                    if (cards[cardFamily].Count >= 5)
                    {
                        // Flush reached
                        for (int i = 0; i < 5; i++)
                        {
                            // Get the 5 greater for the flush
                            CombinationCards.Add(cards[cardFamily][cards[cardFamily].Count - 1 - i]);
                        }
                        result = true;
                        break;
                    }
                }
            }
            return (result);
        }

        /// <summary>
        /// Compute outs to reach the combination.
        /// </summary>
        /// <returns>Outs to reach the combination.</returns>
        protected override int ComputeOuts()
        {
            int result = 0;
            Dictionary<CardFamilies, List<Card>> cards = new Dictionary<CardFamilies, List<Card>>();
            foreach (Card card in SeenCards)
            {
                // Sort cards by family
                if (!cards.ContainsKey(card.Family))
                {
                    cards.Add(card.Family, new List<Card>());
                }
                cards[card.Family].Add(card);
            }
            foreach (CardFamilies family in cards.Keys)
            {
                if (cards[family].Count == 4)
                {
                    // 4 cards of the same family
                    result = CardSet.CardsPerFamilyCount - 4;
                    break;
                }
            }
            return (result);
        }
    }
}
