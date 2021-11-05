package com.mindtree.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//@RunWith(Cucumber.class)
@CucumberOptions(
		features ="features",
		glue = "com.mindtree.StepDefination",
		//dryRun = true,
		monochrome = true)
public class BookRunner extends AbstractTestNGCucumberTests
{
	 
}