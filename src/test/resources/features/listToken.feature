Feature: Listar Tokens

  Scenario: Listar token exitoso
    Given El admin esta registrado en el sistema
    And El admin se autentico en el sistema
    When El admin solicita el listado del tokens
    Then El admin obtiene un status code 200
    And El admin observa que la estructura cumple con el formato de "Tokens"


  Scenario: Listar tokens no autorizado
    Given El usuario esta registrado en el sistema
    Given El usuario no esta autenticado en el sistema
    When El usuario solicita el listado del tokens
    Then El usuario obtiene un status code 401
    And El usuario observa que la estructura cumple con el formato de "Errores"


  Scenario: Listar token Sin permiso realizar la operación
    Given El usuario esta registrado en el sistema
    And  El usuario se autentico en el sistema
    And El usuario esta registrado en el sistema
    When El usuario solicita el listado del tokens
    Then El usuario obtiene un status code 403
    And  El usuario observa que la estructura cumple con el formato de "Errores"



