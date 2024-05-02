Feature: Realizar um requisição do tipo PUT via api no site jsonplaceholder

  Scenario Outline: Alterar dados do usuario
    Given usuario deseje alterar um dado do usuario via put na api jsonplaceholder
    When inserir no endpoint "<endpoint>" o ID "<id>"
    And o e-mail como "<email>"
    And a latitude como "<latitude>"
    And a longitude como "<longitude>"
    Then o status como "<statuscode>"
    And o valor "<email>"
    And o valor "<latitude>"
    And o valor "<longitude>"


    Examples:
      | endpoint | id | email              | latitude | longitude | statuscode |  |
      | /users   | 5  | teste@anderson.com | -37.9999 | 81.9999   | 200        |  |