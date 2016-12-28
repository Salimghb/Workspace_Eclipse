using System;
using System.Collections.Generic;
using System.Text;
using Nikoui.PokCommons;
using Nikoui.PokStats.Properties;

namespace Nikoui.PokStats.Combinations
{
    /// <summary>
    /// Royal flush card combination.
    /// Royal flush is reached when at least five cards of the same family with folowing weights (including an ace) are found.
    /// </summary>
    public class RoyalFlushCombination
        : Combination
    {
        /// <summary>
        /// Get the name of the combination.
        /// </summary>
        public override string Name
        {
            get
            {
                return (Resources.RoyalFlush);
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
                return (8);
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
                StraightFlushCombination straightFlush = new StraightFlushCombination();
                straightFlush.Compute(SeenCards, true);
                if (straightFlush.Reached)
                {
                    bool aceFound = false;
                    bool kingFound = false;
                    // Straight flush reached, look for an ace and a king
                    foreach (Card card in straightFlush.CombinationCards)
                    {
                        if (card.Weight == 0)
                        {
                            aceFound = true;
                        }
                        else if(card.Weight == CardSet.CardsPerFamilyCount - 1)
                        {
                            kingFound = true;
                        }
                        if(aceFound && kingFound)
                        {
                            // Royal flush reached
                            CombinationCards.AddRange(straightFlush.CombinationCards);
                            result = true;
                        }
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
            if (SeenCards.Count >= 4)
            {
                for (int family = 0; family <= CardSet.CardFamiliesCount; family++)
                {
                    for (byte i = 0; i < CardSet.CardsPerFamilyCount; i++)
                    {
                        Card testCard = new Card(i, (CardFamilies)family);
                        if (!SeenCards.Contains(testCard))                       
                        {
                            // Try to add missing card one by one
                            List<Card> testCards = new List<Card>(SeenCards);
                            testCards.Add(testCard);
                            RoyalFlushCombination royalFlush = new RoyalFlushCombination();
                            royalFlush.Compute(testCards, true);
                            if (royalFlush.Reached)
                            {
                                // Adding this test card allow to reach the combination, add this as an out
                                result++;
                            }
                        }
                    }
                }
            }
            return (result);
        }
    }
}
