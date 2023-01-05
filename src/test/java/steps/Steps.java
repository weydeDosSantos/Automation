package steps;

import static br.com.automacaoWeb.core.DriverFactory.getDriver;

import org.junit.Assert;

import br.com.automacaoWeb.pages.FormularioPage;
import br.com.automacaoWeb.pages.InicialPage;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;

public class Steps  {
	
	InicialPage inicialPage = new InicialPage();
	FormularioPage formularioPage = new FormularioPage();

	@Dado("^que o usuario acesse a url \"([^\"]*)\"$")
	public void queOUsuarioAcesseAUrl(String site) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		getDriver().get(site);
		getDriver().manage().window().maximize();
		
	}

	@Dado("^muda o valor do combo para Bootstrap V(\\d+) Theme$")
	public void mudaOValorDoComboParaBootstrapVTheme(int arg1) throws Throwable {
		inicialPage.selecionarCombo("Bootstrap V4 Theme");

	}

	@Dado("^clica no botao Add costumer$")
	public void clicaNoBotaoAddCostumer() throws Throwable {
		inicialPage.botaoAddCliente();
		
	}

	@Quando("^preenher o formulario$")
	public void preenherOFormulario() throws Throwable {
		formularioPage.nomeCliente("Teste Loud");
		formularioPage.sobreNome("Teste");
		formularioPage.nomeDoContato("weyde");
		formularioPage.telefone("51 9999-9999");
		formularioPage.enderecoLinha1("Av Assis Brasil, 3970");
		formularioPage.enderecoLinha2("Torre D");
		formularioPage.cidade("Porto Alegre");
		formularioPage.estado("RS");
		formularioPage.codigoPostal("91000-000");
		formularioPage.pais("Brasil");
		formularioPage.doEmpregador("Fixter");
		formularioPage.limiteCredito("200");
		formularioPage.salvar();
		formularioPage.esperaLink();
	}

	@Entao("^valido a mensagem \"([^\"]*)\"$")
	public void validoAMensagem(String arg1) throws Throwable {
		Assert.assertEquals(arg1,formularioPage.mensagem());
	}

}
