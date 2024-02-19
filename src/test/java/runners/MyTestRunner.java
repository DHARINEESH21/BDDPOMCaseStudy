package runners;


import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src//test//resources//features//",
		glue = {"stepDefs"},
		dryRun = false,
		monochrome=true, //to get the clear output
		plugin = {"pretty", //has some junk characters in the output
				"html:target/Reports/HtmlReport.html",
				
				}
		)

      
//to run it as a each steps as a test we use the AbstractNGCucumberTests
public class MyTestRunner extends AbstractTestNGCucumberTests{
	
	

}


