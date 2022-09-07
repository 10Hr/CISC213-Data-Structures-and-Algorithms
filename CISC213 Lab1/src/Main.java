
public class Main {

	public static void main(String[] args) {
		
		System.out.println("Logical OR");
		
		System.out.println("true || true:  " + logicalOr(true, true));

		System.out.println("true || false:  " + logicalOr(true, false));

		System.out.println("false || true:  " + logicalOr(false, true));

		System.out.println("false || false:  " + logicalOr(false, false));

// ---------------------------------------------------------------------
		System.out.println();
		System.out.println("Logical Implication");
		
		System.out.println("true || true:  " + logicalImplication(true, true));

		System.out.println("true || false:  " + logicalImplication(true, false));

		System.out.println("false || true:  " + logicalImplication(false, true));
		
		System.out.println("false || false:  " + logicalImplication(false, false));
			
// ---------------------------------------------------------------------
		System.out.println();
		System.out.println("Logical Equality");
				
		System.out.println("true || true:  " + logicalEquality(true, true));

		System.out.println("true || false:  " + logicalEquality(true, false));

		System.out.println("false || true:  " + logicalEquality(false, true));
				
		System.out.println("false || false:  " + logicalEquality(false, false));
				
// ---------------------------------------------------------------------
		System.out.println();
		System.out.println("Exclusive Disjunction");
				
		System.out.println("true || true:  " + exclusiveDisjunction(true, true));

		System.out.println("true || false:  " + exclusiveDisjunction(true, false));

		System.out.println("false || true:  " + exclusiveDisjunction(false, true));
				
		System.out.println("false || false:  " + exclusiveDisjunction(false, false));
				
// ---------------------------------------------------------------------
		System.out.println();
		System.out.println("Logical NAND");
				
		System.out.println("true || true:  " + logicalNAND(true, true));

		System.out.println("true || false:  " + logicalNAND(true, false));

		System.out.println("false || true:  " + logicalNAND(false, true));
				
		System.out.println("false || false:  " + logicalNAND(false, false));
		
// ---------------------------------------------------------------------
		System.out.println();
		System.out.println("Logical NOR");
						
		System.out.println("true || true:  " + logicalNOR(true, true));

		System.out.println("true || false:  " + logicalNOR(true, false));

		System.out.println("false || true:  " + logicalNOR(false, true));
						
		System.out.println("false || false:  " + logicalNOR(false, false));
				
	}	
	// This is where the magic happens
	private static boolean logicalOr(boolean a, boolean b) {
		return a || b;

	}
	private static boolean logicalImplication(boolean a, boolean b) {
		return !a || b;
	}

	private static boolean logicalEquality(boolean a, boolean b) {
		return (a && b) || (!a && !b);
	}
	
	private static boolean exclusiveDisjunction(boolean a, boolean b) {
		return (a || b) && (!a || !b);
	}
	
	private static boolean logicalNAND(boolean a, boolean b) {
		return !a || !b;
	}
	
	private static boolean logicalNOR(boolean a, boolean b) {
		return !a && !b;
	}
}
