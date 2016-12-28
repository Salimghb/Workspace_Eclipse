using System;
using System.Collections.Generic;
using System.Text;
using Nikoui.PokCommons;
using Nikoui.PokStats.Properties;

namespace Nikoui.PokStats.Combinations
{
    /// <summary>
    /// Triplets card combination.
    /// Triplets is reached when at least three cards of the same weight are found.
    /// </summary>
    public class TripletsCombination
        : Combination
    {
        /// <summary>
        /// Get the name of the combination.
        /// </summary>
        public override string Name
        {
            get
            {
                return(Resources.Triplets);
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
                return (2);
            }
        }

        /// <summary>
        /// Check if the combination is reached.
        /// </summary>
        /// <returns><c>true</c> if combination is reached, <c>false</c> otherwise.</returns>
        protected override bool ComputeReached()
        {
            bool result = false;
            if (SeenCards != null && SeenCards.Count >= 3)
            {
                foreach (Card card1 in SeenCards)
                {
                    foreach (Card card2 in SeenCards)
                    {
                        foreach (Card card3 in SeenCards)
                        {
                            if (!card1.Equals(card2) && !card2.Equals(card3) && !card1.Equals(card3))
                            {
                                if (card1.Weight == card2.Weight && card2.Weight == card3.Weight)
                                {
                                    // Triplets reached
                                    CombinationCards.Add(card1);
                                    CombinationCards.Add(card2);
                                    CombinationCards.Add(card3);
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
            DoublePairsCombination doublePairs = new DoublePairsCombination();
            doublePairs.Compute(SeenCards, true);
            if (doublePairs.Reached)
            {
                // Two pairs
                result = 4;
                List<Card> seenCardsClone = new List<Card>(SeenCards);
                foreach (Card card in doublePairs.CombinationCards)
                {
                    seenCardsClone.Remove(card);
                }
                PairCombination pair = new PairCombination();
                pair.Compute(seenCardsClone);
                if (pair.Reached)
                {
                    // Three pairs
                    result += 2;
                }
            }
            else
            {
                PairCombination pair = new PairCombination();
                pair.Compute(SeenCards, true);
                if (pair.Reached)
                {
                    // Already a pair, missing one card
                    result = 2;
                }                
            }
            return (result);
        }
    }
}
