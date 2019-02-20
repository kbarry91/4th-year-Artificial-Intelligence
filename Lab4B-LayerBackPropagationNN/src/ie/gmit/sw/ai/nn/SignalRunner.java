package ie.gmit.sw.ai.nn;

import ie.gmit.sw.ai.nn.activator.Activator;

public class SignalRunner {
	
public static void main(String[] args) throws Exception{
	
	double[] test = {1, 1, 0, 1};
	SignalRunner sr = new SignalRunner();
	
}

	public int getCategory(double[] values) throws Exception {
		NeuralNetwork nn = new NeuralNetwork(Activator.ActivationFunction.Sigmoid, 4, 6, 14);
		
		BackpropagationTrainer trainer = new BackpropagationTrainer(nn);
		trainer.train(data, expected, 0.2, 500);

		double[] test = {1, 1, 0, 1};
		double[] result = nn.process(test);
		System.out.println(Utils.getMaxIndex(result) + 1;
	}
}
