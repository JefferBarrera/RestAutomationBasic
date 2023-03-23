Feature: API reqres.in peticion Post crear usuario
    @postUsuario
    Scenario: Creando un usuario Post
        Given queremos crear un usuario
        Then validamos status code 201
        And validamos creacion del usuario