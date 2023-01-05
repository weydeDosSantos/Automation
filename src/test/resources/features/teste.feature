# language: pt
@tag
Funcionalidade: Fluxo cadastro cliente

@tag1
Cenario: Salvar dados de usuario
Dado que o usuario acesse a url "https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap"
E muda o valor do combo para Bootstrap V4 Theme
E clica no botao Add costumer
Quando preenher o formulario 
Entao valido a mensagem "Your data has been successfully stored into the database. Edit Record or Go back to list"

