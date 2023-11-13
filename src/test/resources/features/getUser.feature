Feature: obtener un usuario

  Scenario: Get user exitoso
    Given El admin esta autenticado en el sistema
    When El admin solicita informacion de un usuario
    Then El Administrador obtengo un status code 200
    And El admin obtiene los datos del usuario

  Scenario: Get user no autorizado
    Given El user no esta autorizado en el sistema
    When El user solicita informacion de un usuario
    Then El Administrador obtengo un status code 401

  Scenario: Get user Sin permiso realizar la operación
    Given El user autenticado no tiene permisos
    When El user solicita informacion de un usuario
    Then El Administrador obtengo un status code 403

  Scenario: Get user Recurso no encontrado
    Given El admin esta autenticado en el sistema
    When El admin solicita informacion de usuario no existente
    Then El Administrador obtengo un status code 404