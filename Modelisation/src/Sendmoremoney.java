import static choco.Choco.*;
import choco.kernel.model.variables.integer.IntegerVariable;
import choco.Choco;
import choco.cp.model.CPModel;
import choco.kernel.model.Model;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.solver.Solver;
import choco.cp.solver.CPSolver;

public class Sendmoremoney {


	public static void main(String [] argv){


		// Creation du modele
		Model m = new CPModel();

		// Creation et ajout des variables et de leurs domaines
		int numberOfVariables = 8;
		IntegerVariable [] variable = 
				new IntegerVariable[numberOfVariables];
		String [] name = {"S","E","N","D",
				"M","O","R","Y"};
		for(int i=0; i<numberOfVariables; i++){
			variable[i] = Choco.makeIntVar(name[i],0,9);
			m.addVariable(variable[i]);
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
				Choco.eq(plus(mult(1000,variable[0]),
						plus(mult(100,variable[1]),
								plus(mult(10,variable[2]),
										plus(variable[3],
												plus(mult(1000,variable[4]),
														plus(mult(100,variable[5]),
																plus(mult(10,variable[6]),
																		variable[1]))))))),
																		plus(mult(10000,variable[4]),
																				plus(mult(1000,variable[5]),
																						plus(mult(100,variable[2]),
																								plus(mult(10,variable[1]),
																										variable[7])))));
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
