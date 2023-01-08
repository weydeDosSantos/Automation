# language: pt
@tag
Funcionalidade: Fluxo cadastro cliente

@tag1
Cenario: Salvar dados de usuario
Dado que o usuario acesse a url "https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap "
E muda o valor do combo para "Bootstrap V4 Theme"
E clica no botao Add costumer
Quando preenher o formulario 
Entao valido a mensagem "Your data has been successfully stored into the database. Edit Record or Go back to list"

@tag2
Cenario: deletar usuario salvo.
Dado acesse a url "https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap "
E pesquise o cliente cadastrado 
E clique no check box para seleciona-lo
E clico em deletar
Entao valido o texto "Are you sure that you want to delete this 1 item?" 
E clico no botao deletar
Entao valido o proximo texto "Your data has been successfully deleted from the database."

