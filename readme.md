#Spring Boot Application (Oracle DB | Active MQ)

##This Application exposes total 3 api's.
###Save User     - POST --> /users
    if the User already exists with UserName, the entity object will be updated
    and saved.
    
    {
        "username" : "testUName",
        "name": "test",
        "city": "irvine",
        "country" : "USA"
    }

###Get Users     - GET --> /users
###Delete User   - Delete --> /users/{id}


##Run the docker-compose.yml file to start the following instances.
    OracleDB
    ActiveMQ
    Application (port: 8080)

