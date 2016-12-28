
public class Proba {

	   public static  double  getEquity ( double []  payouts,  double []  stacks,  int  player )  
	   { 
	     double  total =  0 ; 
	     for  ( int  i =  0 ; i < stacks.length; i++ ) 
	       total += stacks [ i ] ; 
	     return  getEquity ( payouts, stacks.clone () , total, player,  0 ) ; 
	   } 

	   //Recursive method doing the actual calculation. 
	   private static  double  getEquity ( double []  payouts,  double []  stacks,  double  total,  int  player,  int  depth )  
	   { 
	     double  eq = stacks [ player ]  / total * payouts [ depth ] ; 

	     if ( depth +  1  < payouts.length ) 
	       for  ( int  i =  0 ; i < stacks.length; i++ )  
	         if  ( i != player && stacks [ i ]  >  0.0 ) { 
	           double  c = stacks [ i ] ; 
	           stacks [ i ]  =  0.0 ; 
	           eq += getEquity ( payouts, stacks, total - c, player, depth +  1 )  * c / total; 
	           stacks [ i ]  = c; 
	         } 
	     
	     return  eq; 
	   }
}
