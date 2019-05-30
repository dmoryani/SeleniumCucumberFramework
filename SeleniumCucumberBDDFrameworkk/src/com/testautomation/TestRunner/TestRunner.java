package com.testautomation.TestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		
		features= {"features"}, 
		glue={"com.testautomation.StepDef"},
		tags={"@UATTesting"},
		plugin={"pretty", "html:target/cucumber.json"},
		monochrome=true)
		
public class TestRunner {
	//Cucumbers inbuilt class
	private TestNGCucumberRunner testNGCucumberRunner; 
	
	@BeforeClass(alwaysRun=true)
	
	public void setUpClass(){
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());//getting the class and all the properties..
	}
	
	@Test(dataProvider= "features")
	
	public void feature(CucumberFeatureWrapper cucumberFeature){
		
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
		
	}
	
	@DataProvider
	
	public Object[][] features(){
		return testNGCucumberRunner.provideFeatures();
	}
	
   @AfterClass(alwaysRun=true)
	   public void teardown(){
	   testNGCucumberRunner.finish();
		   
	   }
	   
   }

