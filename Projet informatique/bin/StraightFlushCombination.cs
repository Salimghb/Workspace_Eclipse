using System;
using System.Collections.Generic;
using System.Text;
using Nikoui.PokCommons;
using Nikoui.PokStats.Properties;

namespace Nikoui.PokStats.Combinations
{
    /// <summary>
    /// Straight flush card combination.
    /// Straight flush is reached when at least five cards of the same family with folowing weights are found.
    /// </summary>
    public class StraightFlushCombination
        : Combination
    {
        /// <summary>
        /// Get the name of the combination.
        /// </summary>
        public override string Name
        {
            get
            {
                return (Resources.StraightFlush);
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
                return (7);
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
                FlushCombination flush = new FlushCombination();
                flush.Compute(SeenCards, true);
                if (flush.Reached)
                {
                    // A flush is found, check for a straight of the flush family
                    CardFamilies family = flush.CombinationCards[0].Family;
                    // Get all the card of the flush family
                    List<Card> seenCardsClone = new List<Card>();
                    foreach (Card card in SeenCards)
                    {
                        if (card.Family == family)
                        {
                            seenCardsClone.Add(card);
                        }
                    }
                    // Look for a straight in this sub set
                    StraightCombination straight = new StraightCombination();
                    straight.Compute(seenCardsClone, true);
                    if (straight.Reached)
                    {
                        // Straight flush found
                        CombinationCards.AddRange(straight.CombinationCards);
                        result = true;
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
                            StraightFlushCombination straightFlush = new StraightFlushCombination();
                            straightFlush.Compute(testCards, true);
                            if (straightFlush.Reached)
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
