package ie.gmit.sw.ai;

import ie.gmit.sw.ai.nn.BackpropagationTrainer;
import ie.gmit.sw.ai.nn.NeuralNetwork;
import ie.gmit.sw.ai.nn.Utils;
import ie.gmit.sw.ai.nn.activator.Activator;

public class GameRunner {

	private NeuralNetwork nn = null;
	
	public GameRunner() throws Exception{
		// Configure
		nn = new NeuralNetwork(Activator.ActivationFunction.Sigmoid, 4, 3, 4);
		
		// Train
		BackpropagationTrainer trainer = new BackpropagationTrainer(nn);
		trainer.train(data, expected, 0.6, 10000);
	}
	
	public String getAction(int health, boolean hasSword, boolean hasGun, int enemies)throws Exception {
		
		// Prepare Inputs
		double h = (double) health;
		double s = hasSword ? 1: 0;
		double g = hasGun ? 1: 0;
		double e = (double) enemies; 
		
		double[] inputs = {h, s, g, e};
		double[] result = nn.process(inputs);
		int category =  Utils.getMaxIndex(result) + 1;
		
		if(category == 1) {
			return "Panic";
		}else if(category == 2){
			return "Attack";
		}else if(category == 3) {
			return "Hide";
		}else {
			return "Run";
		}
	}
	
	public static void main(String[] args) throws Exception {
		GameRunner gm = new GameRunner();
		String action = gm.getAction(2, true, true, 2);
		
		System.out.println(action);
	}
	
	private double[][] data = { //Health, Sword, Gun, Enemies
			{ 2, 0, 0, 0 }, { 2, 0, 0, 1 }, { 2, 0, 1, 1 }, { 2, 0, 1, 2 }, { 2, 1, 0, 2 },
			{ 2, 1, 0, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 0, 1, 1 }, { 1, 0, 1, 2 }, 
			{ 1, 1, 0, 2 }, { 1, 1, 0, 1 }, { 0, 0, 0, 0 }, { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, 
			{ 0, 0, 1, 2 }, { 0, 1, 0, 2 }, { 0, 1, 0, 1 } };

	private double[][] expected = { //Panic, Attack, Hide, Run
			{ 0.0, 0.0, 1.0, 0.0 }, { 0.0, 0.0, 1.0, 0.0 }, { 1.0, 0.0, 0.0, 0.0 }, { 1.0, 0.0, 0.0, 0.0 }, 
			{ 0.0, 0.0, 0.0, 1.0 }, { 1.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 1.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 }, 
			{ 1.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 }, { 0.0, 0.0, 0.0, 1.0 }, { 0.0, 0.0, 0.0, 1.0 }, 
			{ 0.0, 0.0, 1.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 }, { 0.0, 0.0, 0.0, 1.0 }, { 0.0, 1.0, 0.0, 0.0 }, 
			{ 0.0, 1.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 } };
}
