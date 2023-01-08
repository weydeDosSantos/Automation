package steps;

import static br.com.automacaoWeb.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.automacaoWeb.core.DriverFactory;
import br.com.automacaoWeb.core.Dsl;
import br.com.automacaoWeb.pages.FormularioPage;
import br.com.automacaoWeb.pages.InicialPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.Entao;

public class Test2Steps{

	FormularioPage formularioPage = new FormularioPage();
	InicialPage inicialPage = new InicialPage();
	Dsl dsl = new Dsl();
	
	@Dado("^acesse a url \"([^\"]*)\"$")
	public void acesseAUrl(String arg1) throws Throwable {
		dsl.navegar(arg1);
		}

	@Dado("^pesquise o cliente cadastrado$")
	public void pesquiseOClienteCadastrado() throws Throwable {
		inicialPage.procurarCliente("Teste Loud");
	}

	@Dado("^clique no check box para seleciona-lo$")
	public void cliqueNoCheckBoxParaSelecionaLo() throws Throwable {
		formularioPage.esperaCheckBox();
		inicialPage.checkBox();
	}

	@Dado("^clico em deletar$")
	public void clicoEmDeletar() throws Throwable {
		inicialPage.botaoDeleta();
	}

	@Entao("^valido o texto \"([^\"]*)\"$")
	public void validoOTexto(String arg1) throws Throwable {
		Assert.assertEquals(arg1, inicialPage.obterTextoCaixaDialogo());
	}

	@Entao("^clico no botao deletar$")
	public void clicoNoBotaoDeletar() throws Throwable {
		inicialPage.botaoDeletaCaixaDialogo();
	
	}

	@Entao("^valido o proximo texto \"([^\"]*)\"$")
	public void validoOProximoTexto(String arg1) throws Throwable {
		inicialPage.esperaPopUp();
		Assert.assertEquals(arg1, inicialPage.obterTextoPopUp());
		Assert.assertEquals(arg1, inicialPage.obterTextoPopUp());
	}
		@After
		public void screenshot(Scenario cenario) {
			File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("target/screenshot/" + cenario.getId() + ".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			DriverFactory.killDriver();
	}

		
}
