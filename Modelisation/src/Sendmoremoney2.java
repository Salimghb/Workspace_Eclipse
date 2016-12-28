
import static choco.Choco.*;
import choco.kernel.model.variables.integer.IntegerVariable;
import choco.Choco;
import choco.cp.model.CPModel;
import choco.kernel.model.Model;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.solver.Solver;
import choco.cp.solver.CPSolver;

public class Sendmoremoney2 {


	public static void main(String [] argv){


		// Creation du modele
		Model m = new CPModel();

		// Creation et ajout des variables et de leurs domaines
		int numberOfVariables = 8;
		int nombrederetenues=3;
		IntegerVariable [] variable = 
				new IntegerVariable[numberOfVariables];
		IntegerVariable [] retenue =
				new IntegerVariable[nombrederetenues];
		String [] name = {"S","E","N","D",
				"M","O","R","Y"};
		for(int i=0; i<numberOfVariables; i++){
			variable[i] = Choco.makeIntVar(name[i],0,9);
			m.addVariable(variable[i]);
		}
		for(int j=0; j<nombrederetenues; j++){
			retenue[j] = Choco.makeIntVar(name[j],0,1);
			m.addVariable(retenue[j]);
		}

		// Creation et ajout des contraintes:

		// 1. S et M ne doivent pas etre 0

		m.addConstraint(Choco.neq(variable[0],0));
		m.addConstraint(Choco.neq(variable[4],0));


		// 2. Toutes les variables doivent etre differentes

		for (int i = 0; i < numberOfVariables; i++){
			for (int j = i + 1; j < numberOfVariables; j++){
				Constraint c = 
						Choco.neq(variable[i],variable[j]);
				m.addConstraint(c);
			}
		}


		// 3. On doit avoir SEND+MORE = MONEY

		Constraint c = 
				Choco.eq(plus(variable[4],variable[2]),plus(mult(10,retenue[0]),variable[8]));
			
		m.addConstraint(c);
		// Creation du solveur
		Solver s = new CPSolver();
		// Lecture du modele
		s.read(m);
		// Resolution du modele
		s.solve();
		// Affichage des solutions
		for(int i=0; i<numberOfVariables; i++)
			System.out.println(s.getVar(variable[i]));
	}    
}


