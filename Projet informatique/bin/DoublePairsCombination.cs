using System;
using System.Collections.Generic;
using System.Text;
using Nikoui.PokCommons;
using Nikoui.PokStats.Properties;

namespace Nikoui.PokStats.Combinations
{
    /// <summary>
    /// Double pairs card combination.
    /// Double pairs is reached when at least two pairs are found.
    /// </summary>
    public class DoublePairsCombination
        : Combination
    {
        /// <summary>
        /// Get the name of the combination.
        /// </summary>
        public override string Name
        {
            get
            {
                return (Resources.DoublePairs);
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
                return (1);
            }
        }

        /// <summary>
        /// Check if the combination is reached.
        /// </summary>
        /// <returns><c>true</c> if combination is reached, <c>false</c> otherwise.</returns>
        protected override bool ComputeReached()
        {
            bool result = false;
            if (SeenCards != null && SeenCards.Count >= 4)
            {
                List<Card> seenCardsClone = new List<Card>(SeenCards);
                PairCombination pair1 = new PairCombination();
                pair1.Compute(seenCardsClone, true);
                if (pair1.Reached)
                {
                    // First pair found, look for a pair in remaining cards
                    // Remove first pair cards
                    foreach (Card card in pair1.CombinationCards)
                    {
                        CombinationCards.Add(card);
                        seenCardsClone.Remove(card);
                    }
                    PairCombination pair2 = new PairCombination();
                    pair2.Compute(seenCardsClone, true);
                    if (pair2.Reached)
                    {
                        // Two pairs reached
                        CombinationCards.AddRange(pair2.CombinationCards);
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
            PairCombination pair = new PairCombination();
            pair.Compute(SeenCards, true);
            if (pair.Reached)
            {
                // A single pair is already reached, compute outs to reach a second pair
                result = 3 * (SeenCards.Count - 2);
            }
            return (result);
        }
    }
}
