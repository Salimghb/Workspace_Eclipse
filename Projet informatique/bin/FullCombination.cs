using System;
using System.Collections.Generic;
using System.Text;
using Nikoui.PokCommons;
using Nikoui.PokStats.Properties;

namespace Nikoui.PokStats.Combinations
{
    /// <summary>
    /// Full card combination.
    /// Full is reached when at least a pair and a triplets are found.
    /// </summary>
    public class FullCombination
        : Combination
    {
        /// <summary>
        /// Get the name of the combination.
        /// </summary>
        public override string Name
        {
            get
            {
                return (Resources.Full);
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
                return (5);
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
                List<Card> seenCardsClone = new List<Card>(SeenCards);
                TripletsCombination triplet = new TripletsCombination();
                triplet.Compute(seenCardsClone, true);
                if (triplet.Reached)
                {
                    // Triplet found, look for a pair in remaining cards
                    // Remove triplet cards
                    foreach (Card card in triplet.CombinationCards)
                    {
                        CombinationCards.Add(card);
                        seenCardsClone.Remove(card);
                    }
                    PairCombination pair = new PairCombination();
                    pair.Compute(seenCardsClone, true);
                    if (pair.Reached)
                    {
                        // Full reached
                        CombinationCards.AddRange(pair.CombinationCards);
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
            TripletsCombination triplets = new TripletsCombination();
            triplets.Compute(SeenCards, true);
            if (triplets.Reached)
            {
                // Already a triples, need a pair
                result = 3 * (SeenCards.Count - 3);
            }
            else
            {
                DoublePairsCombination doublePairs = new DoublePairsCombination();
                doublePairs.Compute(SeenCards, true);
                if (doublePairs.Reached)
                {
                    // Two pairs, need a triplet
                    result = 4;
                }
            }
            return (result);
        }
    }
}
