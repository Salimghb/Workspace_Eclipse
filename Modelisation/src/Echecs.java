import java.util.Scanner;
import static choco.Choco.*;
import choco.kernel.model.variables.integer.IntegerVariable;
import choco.Choco;
import choco.cp.model.CPModel;
import choco.kernel.model.Model;
import choco.kernel.solver.Solver;
import choco.cp.solver.CPSolver;

public class Echecs {
	public static Scanner sc = new Scanner (System.in) ;
	
	public static void main(String [] args){


		// Creation du modele 
		Model m = new CPModel();

		// Creation et ajout des variables et de leurs domaines
		System.out.println("Nombre de reines :");
		int n = sc.nextInt();
		IntegerVariable []x = 
				new IntegerVariable[n];
		IntegerVariable []y = 
				new IntegerVariable[n];
		for(int i=0; i<n; i++){
			x[i] = Choco.makeIntVar("x"+(i+1),1,n);
			m.addVariable(x[i]);
			y[i] = Choco.makeIntVar("y"+(i+1),1,n);
			m.addVariable(y[i]);
		}


		// Creation et ajout des contraintes:

		// Pour toutes paires de variables distinctes

		for (int i = 0; i < n; i++){
			for (int j = i + 1; j < n; j++){
				m.addConstraint(Choco.neq(x[i],x[j]));
				m.addConstraint(Choco.neq(y[i],y[j]));
				m.addConstraint(Choco.neq(
						minus( x[j] , x[i] ),
						minus( y[j] , y[i] ) ) );
				m.addConstraint(Choco.neq(
						minus( x[i] , x[j] ),
						minus( y[j] , y[i] ) ) );
			}
		}

		// Creation du solveur
		Solver s = new CPSolver();
		// Lecture du modele
		s.read(m);
		// Resolution du modele
		s.solve();
		// Affichage des solutions
		for(int i=0; i<n; i++){
			System.out.print(s.getVar(x[i]));
			System.out.print('\t');
			System.out.println(s.getVar(y[i]));
		}
	}
}