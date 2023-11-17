Feature: Permitir generar un token de usuario  en el sistema

  Scenario: Yo quiero generar un token para un usuario
    Given El admin esta registrado en el sistema
    Given El admin esta autenticado
    When El admin invoca el servicio de generar tokens
    Then El Admin obtiene un status code 201
    And  El Admin obtiene una respuesta que contiene el token
    And  El Admin observa que la estructura cumple con el formato de "Token"

  Scenario: Yo quiero generar un token para un usuario con datos incompletos
    Given El admin esta registrado en el sistema
    Given El admin intenta autenticarse con datos incompletos
    When El admin invoca el servicio de generar tokens
    Then El Admin obtiene un status code 400
    And  El Admin obtiene una respuesta que contiene el token
    And  El Admin observa que la estructura cumple con el formato de "Errores"

  Scenario: Yo quiero generar un token para un usuario con datos inconrrectos
    Given El admin esta registrado en el sistema
    Given El admin intenta autenticarse con datos incorrectos
    When El admin invoca el servicio de generar tokens
    Then El Admin obtiene un status code 401
    And  El Admin obtiene una respuesta que contiene el token
    And  El Admin observa que la estructura cumple con el formato de "Errores"