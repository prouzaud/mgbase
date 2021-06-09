// the database will be named "test" - create it if not exists and connect to it
//use test;

//create an admin user on this database (used to run releases scripts / OPS interventions)
db.createUser(
    {
        user: "admin",
        pwd: "pwd_admin",
        roles: [ { role: "dbAdmin", db: "test" } ]
    }
);

//create the applicative use
db.createUser(
    {
        user: "myAppUser",
        pwd: "pwd_myAppUser",
        roles: [ { role: "readWrite", db: "test" } ]
    }
);


//create the applicative use
db.createUser(
    {
        user: "reader",
        pwd: "pwd_reader",1
        roles: [ { role: "read", db: "test" } ]
    }
);

// create the business collections
db.createCollection("persons");
db.persons.createIndex("personId");

db.createCollection("cars");
db.persons.createIndex("carId");