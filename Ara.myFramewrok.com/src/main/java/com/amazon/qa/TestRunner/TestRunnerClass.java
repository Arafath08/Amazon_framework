package com.amazon.qa.TestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions
(features = {"src\\main\\java\\com\\amazon\\qa\\Pages"}, //Path of the Feature Files.
glue= {"com.amazon.qa.StepDefinitions"}, //Path of the Step Definition Files.
format = {"pretty", "html:test-output", "junit:junit_xml/cucumber.xml"}, //To Generate Output in Different types of Reports.
monochrome = true, //To display Console Output in Very Readable Format.
strict = true, //It will check if any step is not defined in Step Definition File. if Missed it will stop an execution.
dryRun=false) //Checks whether all steps in future file has got methods in Step Definition File or No.

public class TestRunnerClass 
{
	private TestNGCucumberRunner testNGCucumberRunner;
	 
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception 
    {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
 
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) 
    {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
 
    @DataProvider
    public Object[][] features() 
    {
        return testNGCucumberRunner.provideFeatures();
    }
 
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception 
    {
        testNGCucumberRunner.finish();
    }
}

//To Run Specific Feature File --- Give Complete Path of Particular Feature File to Run.
//"D:\\Pavan_JavaPractice\\Automation\\BDDFrameworkJUnit\\src\\main\\java\\com\\crm\\qa\\Features\\LoginFeature_1.feature"

//To Run All Feature Files at a Single Time -- Give Path as Below
//"src\\main\\java\\com\\crm\\qa\\Features"