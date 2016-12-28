using System;
using System.Collections.Generic;
using System.Text;
using Nikoui.PokCommons;
using Nikoui.PokStats.Properties;

namespace Nikoui.PokStats.Combinations
{
    /// <summary>
    /// Straight flush card combination.
    /// Straight is reached when at least five cards with folowing weights are found.
    /// </summary>
    public class StraightCombination
        : Combination
    {
        /// <summary>
        /// Get the name of the combination.
        /// </summary>
        public override string Name
        {
            get
            {
                return (Resources.Straight);
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
                return (3);
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
                SortedList<byte, Card> sortedCards = new SortedList<byte, Card>();
                foreach (Card card in SeenCards)
                {
                    // Get the list of ordered weights
                    if (!sortedCards.ContainsKey(card.Weight))
                    {
                        sortedCards.Add(card.Weight, card);
                        if (card.Weight == 0)
                        {
                            // If card is an ace, consider it as the minimum and max weight
                            sortedCards.Add(CardSet.CardsPerFamilyCount, card);
                        }
                    }
                }
                if (sortedCards.Count >= 5)
                {
                    // Look for 5 following weights
                    int followingWeight = 1;
                    byte previousWeight = sortedCards.Keys[0];
                    for (int i = sortedCards.Keys.Count - 1; i >= 0; i--)
                    {
                        if (sortedCards.Keys[i] == previousWeight - 1)
                        {
                            followingWeight++;
                            if (followingWeight >= 5)
                            {
                                // Straight reached
                                for (int j = 0; j < 5; j++)
                                {
                                    // Get the 5 better weight
                                    CombinationCards.Add(sortedCards.Values[(byte)(i + j)]);
                                }
                                result = true;
                                break;
                            }
                        }
                        else
                        {
                            followingWeight = 1;
                        }
                        previousWeight = sortedCards.Keys[i];
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
                List<byte> missingWeights = new List<byte>();
                SortedList<byte, Card> sortedCards = new SortedList<byte, Card>();
                foreach (Card card in SeenCards)
                {
                    // Get the list of ordered weights
                    if (!sortedCards.ContainsKey(card.Weight))
                    {
                        sortedCards.Add(card.Weight, card);
                        if (card.Weight == 0)
                        {
                            // If card is an ace, consider it as the minimum and max weight
                            sortedCards.Add(CardSet.CardsPerFamilyCount, card);
                        }
                    }
                }
                if (sortedCards.Count >= 4)
                {
                    for (byte i = 0; i < CardSet.CardsPerFamilyCount; i++)
                    {
                        if (!sortedCards.ContainsKey(i))
                        {
                            // Try to add one by one missing weight
                            List<Card> temp = new List<Card>(sortedCards.Values);
                            temp.Add(new Card(i, CardFamilies.Clubs));
                            StraightCombination straight = new StraightCombination();
                            straight.Compute(temp, true);
                            if(straight.Reached)
                            {
                                // Adding this weight allow to reach the combination, remember this weight
                                missingWeights.Add(i);
                            }
                        }
                    }
                    if(missingWeights.Count > 0)
                    {
                        foreach(byte missingWeight in missingWeights)
                        {
                            // For each remembered weights, compute outs
                            result += 4;
                            foreach(Card card in SeenCards)
                            {
                                if(card.Weight == missingWeight)
                                {
                                    // Card is part of seen cards, can not be an out
                                    result--;
                                }
                            }
                        }
                    }                
                }
            }
            return (result);
        }
    }
}
