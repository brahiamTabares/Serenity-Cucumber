Feature: Eliminar  un usuario

  Scenario: Eliminar user exitoso
    Given El admin esta registrado en el sistema
    And El admin se autentico en el sistema
    And El usuario esta registrado en el sistema
    When El admin elimina un usuario del sistema
    Then El admin obtiene un status code 204


  Scenario: Eliminar user no autorizado
    Given El usuario esta registrado en el sistema
    And El usuario no esta autenticado en el sistema
    When El usuario elimina un usuario del sistema
    Then El usuario obtiene un status code 401
    And El usuario observa que la estructura cumple con el formato de "Errores"

  Scenario: Eliminar user Sin permiso realizar la operación
    Given El usuario esta registrado en el sistema
    And  El usuario se autentico en el sistema
    And El usuario esta registrado en el sistema
    When El usuario elimina un usuario del sistema
    Then El usuario obtiene un status code 403
    And  El usuario observa que la estructura cumple con el formato de "Errores"

  Scenario: Eliminar user Recurso no encontrado
    Given El admin esta registrado en el sistema
    And El admin se autentico en el sistema
    And El usuario no existe en el sistema
    When El admin elimina un usuario del sistema
    Then El admin obtiene un status code 404
    And  El admin observa que la estructura cumple con el formato de "Errores"
