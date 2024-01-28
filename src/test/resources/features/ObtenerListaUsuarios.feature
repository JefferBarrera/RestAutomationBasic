Feature: API reqres.in peticion Get lista

    @getLista
    Scenario: Obteniendo lista de usuarios Get
        Given queremos obtener lista de usuarios
        Then validamos status code 200