Feature: validar consulta do array

  Scenario: Validar consulta do array
    Given que acesse o site jsonplaceholder
    And selecione o menu "Guide"
    When acessar o link "/album/1/photos"
    Then o sistema apresenta o ID "6"
    And com o título "accusamus ea aliquid et amet sequi nemo"