using System;
using System.Collections.Generic;
using System.Text;
using Nikoui.PokCommons;

namespace Nikoui.PokStats.Combinations
{
    /// <summary>
    /// Abstract class for card combination.
    /// Each combination provides its outs and probability.
    /// When a combination is reached, it provides implied cards.
    /// </summary>
    public abstract class Combination
    {
        #region Private fields
        /// <summary>
        /// Outs for the combination at the current stage.
        /// </summary>
        private int outs;

        /// <summary>
        /// Value indicating if the combination is reached or not.
        /// </summary>
        private bool reached;

        /// <summary>
        /// List of cards implied in the reached combination.
        /// </summary>
        private List<Card> combinationCards;

        /// <summary>
        /// Seen card at the current stage.
        /// </summary>
        private List<Card> seenCards;

        /// <summary>
        /// Probability to reach the combination at the current stage.
        /// </summary>
        private double probability;
        #endregion //Private fields

        #region Properties
        /// <summary>
        /// Get the outs to reach the combination at current stage.
        /// </summary>
        public int Outs
        {
            get
            {
                return (outs);
            }
        }

        /// <summary>
        /// Get a value indicating if the combination is reached or not.
        /// </summary>
        public bool Reached
        {
            get
            {
                return (reached);
            }
        }

        /// <summary>
        /// Get the probability to reach the combination (between 0.0 and 1.0).
        /// </summary>
        public double Probability
        {
            get
            {
                return (probability);
            }
        }

        /// <summary>
        /// Get the list of cards implied in the reached combination.
        /// </summary>
        public List<Card> CombinationCards
        {
            get
            {
                return (combinationCards);
            }
        }

        /// <summary>
        /// Get the list of seen cards at current stage.
        /// </summary>
        protected List<Card> SeenCards
        {
            get
            {
                return (seenCards);
            }
        }
        #endregion //Properties

        /// <summary>
        /// Default constructor.
        /// </summary>
        public Combination()
        {
            outs = 0;
            probability = 0.0;
            reached = false;
            combinationCards = new List<Card>();
            seenCards = null;
        }

        /// <summary>
        /// Check if the combination is reached, and if it not, compute the combination properties.
        /// </summary>
        /// <param name="seenCards">Seen cards at the current stage.</param>
        public void Compute(List<Card> seenCards)
        {
            Compute(seenCards, false);
        }

        /// <summary>
        /// Check if the combination is reached, and if it not and if asked, compute the combination properties.
        /// </summary>
        /// <param name="seenCards">Seen cards at the current stage.</param>
        /// <param name="onlyReached">
        /// <c>true</c> to only check if the combination is reached, <c>false</c> to also compute outs and probability.
        /// </param>
        public void Compute(List<Card> seenCards, bool onlyReached)
        {
            this.seenCards = seenCards;
            // Check if combination is reached
            reached = ComputeReached();
            if (!reached && !onlyReached)
            {
                // Combination not reached yet, compute outs
                outs = ComputeOuts();
                if (outs > 0)
                { 
                    // Compute probability
                    probability = ComputeProbability();
                }
            }
        }

        /// <summary>
        /// Compute the probability to reach the combination at current stage.
        /// </summary>
        /// <returns>The probability (double value between 0.0 and 1.0).</returns>
        private double ComputeProbability()
        {
            double result;
            int totalCard = CardSet.CardFamiliesCount * CardSet.CardsPerFamilyCount;
            result = (double)outs / (double)(totalCard - SeenCards.Count);
            return (result);
        }

        #region Abstract members
        /// <summary>
        /// Check if the combination is reached.
        /// </summary>
        /// <returns><c>true</c> if combination is reached, <c>false</c> otherwise.</returns>
        protected abstract bool ComputeReached();

        /// <summary>
        /// Compute outs to reach the combination.
        /// </summary>
        /// <returns>Outs to reach the combination.</returns>
        protected abstract int ComputeOuts();

        /// <summary>
        /// Get the name of the combination.
        /// </summary>
        public abstract string Name
        {
            get;
        }

        /// <summary>
        /// Get the weight of the combination.
        /// Weight allow to compare combination values.
        /// </summary>
        public abstract byte Weight
        {
            get;
        }
        #endregion //Abstract members
    }
}
