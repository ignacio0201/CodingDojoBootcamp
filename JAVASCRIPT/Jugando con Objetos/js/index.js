//Practica iterar por medio de un array de objetos/diccionarios.
//Imagina que se te entrega un array de objetos. Por ejemplo,

//var users = [{name: "Michael", age:37}, {name: "John",  age:30}, {name: "David", age:27}];

// ¿Cómo harías print/log de la edad de John?
// ¿Cómo harías print/log del nombre del primer objeto?
// ¿Cómo harías print/log del nombre y la edad de cada usuario utilizando un for loop? Tu output debería verse algo como esto :
// Michael - 37
// John - 30
// David - 27
// ¿Cómo harías para imprimir el nombre de los mayores de edad?

function printUsers() {
    const mayoriaEdad = 18;
    var users = [{name: "Michael", age:37}, {name: "John",  age:30}, {name: "David", age:27}];

    //Edad de John
    console.log("La edad de John es:", users[1].age);
    //Nombre del primer objeto
    console.log("El primer usuario es:", users[0].name);
    //Nombre y edad de cada usuario
    for (let i = 0; i < users.length; i++) {
    console.log("Nombre y edad de cada usuario:", users[i].name, "-", users[i].age);
    }
    //Usuarios mayores de edad
    for (let i = 0; i < users.length; i++) {
        if (users[i].age >= mayoriaEdad) {
            console.log("Usuarios mayores de edad:", users[i].name);
        }
    }
}
printUsers();








 