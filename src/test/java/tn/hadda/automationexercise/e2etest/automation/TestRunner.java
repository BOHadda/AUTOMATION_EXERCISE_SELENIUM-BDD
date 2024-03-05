package tn.hadda.automationexercise.e2etest.automation;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
features = {"src/specs/features"}, 
plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber-report.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
tags =("@validregister"),
snippets = SnippetType.CAMELCASE,
monochrome = true)

public class TestRunner {

}
 