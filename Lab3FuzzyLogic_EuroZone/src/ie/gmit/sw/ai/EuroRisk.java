package ie.gmit.sw.ai;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class EuroRisk {
	public static void main(String[] args) throws Exception {
		System.out.println(new EuroRisk().getRisk(98.0d,3.0d)*10);
	}

	public double getRisk(double debtGDPRatio, double growth) {

		FIS fis = FIS.load("fcl/euro.txt", true); // Load and parse the FCL
	
		fis.setVariable("debtGDPRatio", debtGDPRatio);
		fis.setVariable("growth", growth);
		
		fis.evaluate(); // Execute the fuzzy inference engine

		JFuzzyChart.get().chart(fis); // Display fuzzy charts

		JFuzzyChart.get().chart(fis.getVariable("risk").getDefuzzifier(), "Risk", true);
		return fis.getVariable("risk").getValue();
	}

}
