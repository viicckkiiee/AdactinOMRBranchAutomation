package com.runner;

import org.testng.annotations.AfterClass;

import com.reports.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(snippets=SnippetType.CAMELCASE,strict=false,dryRun=false,plugin= {"pretty","json:target/cucumber.json"},monochrome=true,features="src/test/resources",glue="com.stepdefinition")
public class TestRunnerClass extends AbstractTestNGCucumberTests {
	
	@AfterClass
	public static void afterClass() {
		
		Reporting.generateJVMReport(System.getProperty("user.dir")+"\\target\\cucumber.json");
	}
	
}
