Feature: Realizar um requisição do tipo GET via api no site jsonplaceholder

  Description: Validar dados recebidos da api de uma requisição GET

  Scenario: Consultar o atributo name do endpoint comments
    Given o usuário deseja efetuar uma consulta via GET na API jsonplaceholder
    When pesquisar no endpoint "/comments" o valor "?name=alias%20odio%20sit"
    Then o sistema deve retornar o status "200"
    And o e-mail "Lew@alysha.tv"