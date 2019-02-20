package ie.gmit.sw.ai.nn;

import java.util.Arrays;

import ie.gmit.sw.ai.nn.activator.*;

public class XORrunner {
	public static long getRoundedValue(double[] vector) {
		System.out.println("Output Layer ....");
		Arrays.stream(vector).forEach(System.out::println);
		return Math.round(vector[0]);
	}

	public static void main(String[] args) throws Exception {
		double[][] data = {
				{ 0, 0 }, 
				{ 1, 0 }, 
				{ 0, 1 },
				{ 1, 1 }
				};
		
		double[][] expected = {
				{ 0 }, 
				{ 1 }, 
				{ 1 }, 
				{ 0 } 
				};

		NeuralNetwork nn = new NeuralNetwork(Activator.ActivationFunction.Sigmoid, 2, 2, 1);
		BackpropagationTrainer trainer = new BackpropagationTrainer(nn);
		trainer.train(data, expected, 0.01, 1000000);

		double[] test1 = { 0.0, 0.0 };
		double[] test2 = { 1.0, 0.0 };
		double[] test3 = { 0.0, 1.0 };
		double[] test4 = { 1.0, 1.0 };

		System.out.println("00=>" + getRoundedValue(nn.process(test1)));
		System.out.println("10=>" + getRoundedValue(nn.process(test2)));

		System.out.println("01=>" + getRoundedValue(nn.process(test3)));

		System.out.println("11=>" + getRoundedValue(nn.process(test4)));

	}

}
