Feature: Permitir generar un token de usuario  en el sistema

  Scenario: Yo quiero generar un token para un usuario
    Given El administrador esta autenticado
    When El administrador invoca el servicio de generar tokens
    Then El Administrador obtengo un status code 201
    And  El Administrador obtiene una respues que contiene el token

  Scenario: Yo quiero generar un token para un usuario con datos incompletos
    Given El administrador intenta autenticarse con datos incompletos
    When El administrador invoca el servicio de generar tokens
    Then El Administrador obtengo un status code 400
    And  El Administrador obtiene una respues que contiene el token

  Scenario: Yo quiero generar un token para un usuario con datos inconrrectos
    Given El administrador intenta autenticarse con datos incorrectos
    When El administrador invoca el servicio de generar tokens
    Then El Administrador obtengo un status code 401
    And  El Administrador obtiene una respues que contiene el token