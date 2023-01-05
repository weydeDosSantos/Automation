package br.com.automacaoWeb.core;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = "pretty",
		features = {"src/test/resources/features"},
		glue = "steps",
		monochrome = true,
		snippets = SnippetType.CAMELCASE
		
		)


public class Runner {
	

}
