Feature: Realizar uma requisição do tipo POST

  Description: Cadastrar usuário na API

  Scenario:  Adicionar um novo usuário
    Given usuario deseje inserir um novo usuario via get na api jsonplaceholder pelo eindpoint "/users"
    When enviar o name com o valor "<name>"
    And o email com o valor "<email>"
    And o endereço com o valor "<street>"
    And o complemento suite com o valor "<suite>"
    And a cidade com o valor "<city>"
    And a telefone com o valor "<phone>"
    And o website com o valor "<website>"
    Then o sistema deve retornar o status como "201"
    And o id "11"

    Examples:
      | name                  | email                  | street               | suite     | city      | phone          | website             |  |
      | Anderson Wagner Alves | testedesafio@gmail.com | Rua da independencia | Apto. 208 | Joinville | (49) 999999998 | desafioanderson.com |  |