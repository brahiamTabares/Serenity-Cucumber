Feature: Permitir registar un usuario en el sistema

  Scenario: Yo quiero registrarme en el sistemma como usuario
    Given brahiam registra un usuario no existente
    When brahiam invoca el servicio de registro
    Then brahiam obtengo un status code 201

  Scenario: yo quiero registrarme en el sistema con datos incompletos
    Given voy a registarme como un usuario con datos faltantes
    When brahiam invoca el servicio de registro
    Then brahiam obtengo un status code 400

  Scenario: Soy un usuario ya registrado
    Given voy a registarme como un usuario ya existente
    When brahiam invoca el servicio de registro
    Then brahiam obtengo un status code 409


