Feature: API reqres.in peticion Delete usuario

    @deleteUsuario
    Scenario: Eliminar un usuario en especifico Delete
        Given queremos eliminar un usuario con id 2
        Then validamos status code 204
