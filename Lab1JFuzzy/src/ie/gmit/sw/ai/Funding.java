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
public class Funding {

	public static void main(String[] args) throws Exception {
		
		FIS fis = FIS.load("conf/funding.fcl", true); 			// Load and parse the FCL
		JFuzzyChart.get().chart(fis);							// Display fuzzy charts
		JFuzzyChart.get().chart("risk", "Risk",true);
		//fis.chart();											// Display the linguistic variables and terms
		
		fis.setVariable("funding", 60); 						// Apply a value to a variable
		fis.setVariable("staffing", 14);
		fis.evaluate(); 										// Execute the fuzzy inference engine
		System.out.println(fis.getVariable("risk").getValue());	// Output end resu
	}

}
