package ie.gmit.sw.ai;

public class PerceptronRunner {
	public static void main(String[] args) {
		float[][] data = {
			{0.00f, 0.00f},
			{1.00f, 0.00f},
			{0.00f, 1.00f},
			{1.00f, 1.00f}
		};
		
		//float[] expected = {0.00f, 0.00f, 0.00f, 1.00f}; //Logical AND
		float[] expected = {0.00f, 1.00f, 1.00f, 1.00f}; //Logical OR

		
		Perceptron p = new Perceptron(2);
		p.train(data, expected, 10000);
		
		//Test...
		for (int row = 0; row < data.length; row++){
			int result = p.activate(data[row]);
			System.out.println("Result " + row + ": " + result);			
		}
	}
}