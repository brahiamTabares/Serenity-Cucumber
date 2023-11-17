Feature: obtener un usuario

  Scenario: Get user exitoso
    Given El admin esta registrado en el sistema
    And El admin se autentico en el sistema
    When El admin solicita informacion de "el"
    Then El admin obtiene un status code 200
    And El admin obtiene los datos del usuario
    And El admin observa que la estructura cumple con el formato de "User"

  Scenario: Get user no autorizado
    Given El usuario no esta autenticado en el sistema
    When El usuario solicita informacion de "el"
    Then El usuario obtiene un status code 401
    And  El usuario observa que la estructura cumple con el formato de "Errores"

  Scenario: Get user Sin permiso realizar la operación
    Given El usuario esta registrado en el sistema
    And El usuario se autentico en el sistema
    When El usuario solicita informacion de "admin"
    Then El usuario obtiene un status code 403
    And  El usuario observa que la estructura cumple con el formato de "Errores"

  Scenario: Get user Recurso no encontrado
    Given El admin esta registrado en el sistema
    And El admin se autentico en el sistema
    When El admin solicita informacion de usuario no existente
    Then El admin obtiene un status code 404
    And  El admin observa que la estructura cumple con el formato de "Errores"
