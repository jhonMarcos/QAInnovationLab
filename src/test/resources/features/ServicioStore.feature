@servicioTest
Feature: Servicios de Store

  @creacionOrder
  Scenario Outline: Creacion de order exitoso
    Given ingrese a la pagina web
    When creo el order con el id "<ID>", el petId "<PETID>", la cantidad "<CANTIDAD>", la fecha de envio "<FECHAENVIO>", el estado "<STATUS>" y si fue completado "<COMPLETADO>"
    Then el codigo de respuesta es 200
    And valido el body e la creacion con el id "<ID>", el petId "<PETID>", la cantidad "<CANTIDAD>", la fecha de envio "<FECHAENVIO>", el estado "<STATUS>" y si fue completado "<COMPLETADO>"

    Examples:
    |ID| PETID| CANTIDAD| FECHAENVIO                 | STATUS | COMPLETADO|
    |1 |  1   |1        |2024-07-02T21:15:52.120+0000| placed |true       |
    |2 |  2   |1        |2024-07-02T21:15:52.120+0000| placed |true       |

  @consultaOrder
  Scenario Outline: Consulta de orders
      Given ingrese a la pagina web pestore
      When hago la consulta del id "<IDORDER>"
      Then el codigo de respuesta mostrado es 200
      And valido el body con el id "<ID>", el petId "<PETID>", la cantidad "<CANTIDAD>", la fecha de envio "<FECHAENVIO>", el estado "<STATUS>" y si fue completado "<COMPLETADO>"

      Examples:
      |IDORDER|ID| PETID| CANTIDAD| FECHAENVIO                 | STATUS | COMPLETADO|
      |    1  |1 |  1   |1        |2024-07-02T21:15:52.120+0000| placed |true       |
      |    2  |2 |  2   |1        |2024-07-02T21:15:52.120+0000| placed |true       |