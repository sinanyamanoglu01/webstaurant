package com.webstraunt.runner;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.webstraunt.utilities.ConfigurationReader;
import com.webstraunt.utilities.Driver;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
				"pretty",
				"html:target/default-cucumber-reports",
				"json:target/cucumber.json"
		
		},
		
		tags="@runNow",
		features= {"src/test/resources/features"}, 
		glue= {"com.webstraunt.stepDefinitions"},
		dryRun = false
		)
public class Runner {
	
	

}
