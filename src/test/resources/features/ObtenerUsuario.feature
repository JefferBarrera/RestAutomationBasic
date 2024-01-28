Feature: API reqres.in peticion Get usuario

    @getUsuario
    Scenario: Obteniendo un usuario en especifico Get
        Given queremos obtener un usuario con id 2
        Then validamos status code 200
        And validamos nombre del usuario "Janet"