
public class NewtonsMethod {
	/*
	 * Remember to put in placeholders of 0 and the implied 1.
	 * For example, f(x) = x^5 + 4x^4 + 2x
	 * would have coefficients of
	 * 1, 4, 0, 0, 2, 0
	 * (the constant term counts as the coefficient for x^0)
	 */
	static double[] coefficients = { 1, 4, 0, 0, 2, 0 };

	static double eval(double[] cof, double x) {
		double result = 0;
		for (int a = 0; a < cof.length; a++) {
			result += cof[cof.length - a - 1] * Math.pow(x, a);
		}
		return result;
	}

	static String formatFunction(double[] cof) {
		String function = "f(x) = ";
		for (int a = 0; a < cof.length; a++) {
			if (cof[a] == 0d) {
				continue;
			}
			if (0 < a) {
				function += " + ";
			}
			if (Math.floor(cof[a]) == cof[a]) {
				if (cof[a] != 1d) {
					function += (int) cof[a];
				} else if (a == cof.length - 1) {
					function += (int) cof[a];
				}
			} else {
				function += cof[a];
			}
			int power = cof.length - a - 1;
			if (power == 1) {
				function += "x";
			} else if (power == 0) {
				break;
			} else {
				function += "x^" + power;
			}
		}
		return function;
	}
	
	static double[] derivative(double[] cof) {
		double[] dercof = new double[cof.length - 1];
		for (int a = 0; a < cof.length - 1; a++) {
			int pow = cof.length - a - 1;
			dercof[a] = cof[a] * pow;
		}
		return dercof;
	}
	
	public static void main(String[] args) {
		System.out.println("Function: " + formatFunction(coefficients));
		double[] derivative = derivative(coefficients);
		System.out.println("Derivative: " + formatFunction(derivative));
		double n = coefficients[0];
		do {
			System.out.print("Try n = " + n + "\t");
			double p = eval(coefficients, n);
			System.out.print("f(n) = " + p + "\t");
			double q = eval(derivative, n);
			System.out.println("f'(n) = " + q);
			n -= p / q;
		} while (Math.abs(eval(coefficients, n)) > 0);
		System.out.printf("n = %.5f%n", n);
		System.out.printf("f(n) = %.5f%n", eval(coefficients, n));
	}

}
