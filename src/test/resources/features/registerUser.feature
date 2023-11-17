Feature: Permitir registar un usuario en el sistema

  Scenario: Yo quiero registrarme en el sistemma como usuario
    Given El usuario no existe en el sistema
    When El usuario invoca el servicio de registro
    Then El usuario obtiene un status code 201
    And  El usuario la respuesta contiene los datos del usuario
    And  El usuario observa que la estructura cumple con el formato de "User"


  Scenario: yo quiero registrarme en el sistema con datos incompletos
    Given voy a registarme como un usuario con datos faltantes
    When El usuario invoca el servicio de registro
    Then El usuario obtiene un status code 400
    And  El usuario observa que la estructura cumple con el formato de "Errores"

  Scenario: Soy un usuario ya registrado
    Given El usuario esta registrado en el sistema
    When El usuario invoca el servicio de registro
    Then El usuario obtiene un status code 409
    And  El usuario observa que la estructura cumple con el formato de "Errores"


