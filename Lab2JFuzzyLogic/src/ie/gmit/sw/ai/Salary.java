/**
 * 
 */
package ie.gmit.sw.ai;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

/**
 * @author kevo-
 *
 */
public class Salary {

	public static void main(String[] args) throws Exception {
		System.out.println(new Salary().getSalary(80.00d, 4.0d, 2.5, 45));
	}

	public double getSalary(double iq, double expierence, double qualification, double screen) {

		FIS fis = FIS.load("conf/salary.fcl", true); // Load and parse the FCL
		fis.setVariable("iq", iq);
		fis.setVariable("expierence", expierence);
		fis.setVariable("qualification", qualification);
		fis.setVariable("screen", screen);
		fis.evaluate(); // Execute the fuzzy inference engine

		JFuzzyChart.get().chart(fis); // Display fuzzy charts

		JFuzzyChart.get().chart(fis.getVariable("salary").getDefuzzifier(), "Salary", true);
		return fis.getVariable("salary").getValue();
	}

}
