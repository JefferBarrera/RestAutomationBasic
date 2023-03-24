Feature: API reqres.in peticion Post crear usuario

    @postUsuario
    Scenario Outline: Creando un usuario Post
        Given queremos crear un usuario '<name>' '<job>'
        Then validamos status code 201
        And validamos creacion del usuario

        Examples:
            | name       | job      |
            | "morpheus" | "leader" |