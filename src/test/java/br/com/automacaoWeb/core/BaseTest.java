package br.com.automacaoWeb.core;

import static br.com.automacaoWeb.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class BaseTest {

	@After
	public void feharBrowser(Scenario cenario) {
		File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshot/" + cenario.getId() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		DriverFactory.killDriver();
}
}
