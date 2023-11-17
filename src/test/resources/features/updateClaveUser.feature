Feature: Actualizar clave  un usuario

  Scenario: Update user exitoso
    Given El admin esta registrado en el sistema
    And El admin se autentico en el sistema
    And El usuario esta registrado en el sistema
    When El admin solicita actualizacion de una clave de usuario
    Then El admin obtiene un status code 200
    And El admin obtiene los datos del usuario
    And El admin observa que la estructura cumple con el formato de "User"

  Scenario: Update user con datos incompletos
    Given El admin esta registrado en el sistema
    And El admin se autentico en el sistema
    When El admin solicita actualizacion de un usuario con datos incompletos
    Then El admin obtiene un status code 400
    And  El admin observa que la estructura cumple con el formato de "Errores"
#token vacio
  Scenario: Update user no autorizado
    Given El usuario esta registrado en el sistema
    Given El usuario no esta autenticado en el sistema
    When El usuario solicita actualizacion de un usuario
    Then El usuario obtiene un status code 401
    And El usuario observa que la estructura cumple con el formato de "Errores"

  Scenario: Update user Sin permiso realizar la operación
    Given El usuario esta registrado en el sistema
    And  El usuario se autentico en el sistema
    And El usuario esta registrado en el sistema
    When El usuario solicita actualizacion de un usuario
    Then El usuario obtiene un status code 403
    And  El usuario observa que la estructura cumple con el formato de "Errores"

  Scenario: Update user Recurso no encontrado
    Given El admin esta registrado en el sistema
    And El admin se autentico en el sistema
    And El usuario no existe en el sistema
    When El admin solicita actualizacion de un usuario
    Then El admin obtiene un status code 404
    And  El admin observa que la estructura cumple con el formato de "Errores"
