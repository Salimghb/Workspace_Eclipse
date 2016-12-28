using System;
using System.Collections.Generic;
using System.Text;
using Nikoui.PokCommons;
using Nikoui.PokStats.Properties;

namespace Nikoui.PokStats.Combinations
{
    /// <summary>
    /// Pair card combination.
    /// Pair is reached when at least two cards of the same weight are found.
    /// </summary>
    public class PairCombination
        : Combination
    {
        /// <summary>
        /// Get the name of the combination.
        /// </summary>
        public override string Name
        {
            get
            {
                return (Resources.Pair);
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
                return (0);
            }
        }

        /// <summary>
        /// Check if the combination is reached.
        /// </summary>
        /// <returns><c>true</c> if combination is reached, <c>false</c> otherwise.</returns>
        protected override bool ComputeReached()
        {
            bool result = false;
            if (SeenCards != null && SeenCards.Count >= 2)
            {
                foreach (Card card1 in SeenCards)
                {
                    foreach (Card card2 in SeenCards)
                    {
                        if (!card1.Equals(card2))
                        {
                            if (card1.Weight == card2.Weight)
                            {
                                // Pair reached
                                CombinationCards.Add(card1);
                                CombinationCards.Add(card2);
                                result = true;
                                break;
                            }
                        }
                    }
                    if (result)
                    {
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
            result = 3 * SeenCards.Count;
            return (result);
        }
    }
}
