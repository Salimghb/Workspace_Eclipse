using System;
using System.Collections.Generic;
using System.Text;
using Nikoui.PokCommons;
using Nikoui.PokStats.Properties;

namespace Nikoui.PokStats.Combinations
{
    /// <summary>
    /// Quads card combination.
    /// Quads is reached when four cards of the same weight are found.
    /// </summary>
    public class QuadsCombination
        : Combination
    {
        /// <summary>
        /// Get the name of the combination.
        /// </summary>
        public override string Name
        {
            get
            {
                return (Resources.Quads);
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
                return (6);
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
                DoublePairsCombination doublePairs = new DoublePairsCombination();
                doublePairs.Compute(seenCardsClone, true);
                if (doublePairs.Reached)
                {
                    // Double pair found, check if it is a quads
                    if (doublePairs.CombinationCards[0].Weight == doublePairs.CombinationCards[2].Weight)
                    {
                        // Quads reached
                        CombinationCards.AddRange(doublePairs.CombinationCards);
                        result = true;
                    }
                    else
                    {
                        // Look for a possible third pair
                        foreach (Card card in doublePairs.CombinationCards)
                        {
                            seenCardsClone.Remove(card);
                        }
                        PairCombination pair = new PairCombination();
                        pair.Compute(seenCardsClone, true);
                        if (pair.Reached)
                        {
                            if (pair.CombinationCards[0].Weight == doublePairs.CombinationCards[0].Weight)
                            {
                                // Quads reached
                                CombinationCards.Add(doublePairs.CombinationCards[0]);
                                CombinationCards.Add(doublePairs.CombinationCards[1]);
                                CombinationCards.AddRange(pair.CombinationCards);
                                result = true;
                            }
                            else if (pair.CombinationCards[0].Weight == doublePairs.CombinationCards[2].Weight)
                            {
                                // Quads reached
                                CombinationCards.Add(doublePairs.CombinationCards[2]);
                                CombinationCards.Add(doublePairs.CombinationCards[3]);
                                CombinationCards.AddRange(pair.CombinationCards);
                                result = true;
                            }
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
            TripletsCombination triplets = new TripletsCombination();
            triplets.Compute(SeenCards, true);
            if (triplets.Reached)
            {
                // Triplets reached, need the last card of the triplets weight
                result = 1;
            }
            return (result);
        }
    }
}
