Feature: Permitir registar un usuario en el sistema

  Scenario: Yo quiero registrarme en el sistemma como usuario
    Given voy a registarme como un usuario no existente
    When invoco el servicio de registro
    Then obtengo un status code 201

  Scenario: yo quiero registrarme en el sistema con datos incompletos
    Given voy a registarme como un usuario con datos faltantes
    When invoco el servicio de registro
    Then obtengo un status code 400

  Scenario: Soy un usuario ya registrado
    Given voy a registarme como un usuario ya existente
    When invoco el servicio de registro
    Then obtengo un status code 409

  Scenario: Yo quiero registrarme en el sistemma pero se presenta un fallo del servidor
    Given voy a registarme como un usuario no existente
    When invoco el servicio de registro
    Then obtengo un status code 500

