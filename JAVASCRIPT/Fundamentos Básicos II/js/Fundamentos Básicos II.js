console.log("Ejercicio 1");
//Dado un array, escribe una función que cambie todos los números positivos en él, por el string “big”. Ejemplo: grande([-1,3,5,-5]) devuelve [-1, “big”, “big”, -5].

function grande(array) {
    for (let i = 0; i < array.length; i++) {
        if (array[i] > 0) {
            array[i] = "big";
        }
    }
    return array;
}
console.log("Sus valores han sido modificados:", grande([-1,3,5,-5])); //debe devolver [-1, “big”, “big”, -5]

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 2");
//Imprime (print) el menor, devuelve (return) el mayor - Crea una función que tome un array de números. La función debería imprimir (print) el menor valor del array, y devolver (return) el mayor. 

function printMinReturnMax(array) {
    let min = array[0];
    let max = array[0];

    for (let i = 1; i < array.length; i++) {
        if (array[i] < min) {
            min = array[i];
        }
        if (array[i] > max) {
            max = array[i];
        }
    }
    console.log("El valor menor es:", min); // debe imprimir 1
    return max;
}
console.log("El valor mayor es:", printMinReturnMax([1,2,3,4,5])); //Debe devolver 5

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 3");
//Imprime (print) uno, devuelve (return) otro- Crea una función para un array de números. La función debería imprimir (print) el penúltimo valor y devolver (return) el primer valor impar.

function printPenultimoReturnPrimerImpar(array) {
    console.log("El penúltimo valor es:", array[array.length - 2]);

    for (let i = 0; i < array.length; i++) {
        if (array[i] % 2 != 0) {
            return array[i];
        }
    }
}
console.log("El primer valor impar es:", printPenultimoReturnPrimerImpar([6,-14,9,-18,-21,10]));

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 4");
//Doble Visión - Dado un array, crea una función que devuelva un nuevo array donde cada valor se duplique. Entonces, doble([1,2,3]) debiera devolver [2, 4, 6] sin cambiar el array original. 

function doble(array) {
    let nuevoArr = [];

    for (let i = 0; i < array.length; i++) {
        nuevoArr.push(array[i]*2);
    }
    return nuevoArr;
}
console.log("Su nuevo arreglo es:", doble([1,2,3])); //debe devolver [2, 4, 6]

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 5");
//Dado un array de números, crea una función para reemplazar el último valor con el número de valores positivos encontrados en el array. Ejemplo, contarPositivos([-1,1,1,1]) cambia el array original y devuelve [-1,1,1,3].

function contarPositivos(array) {
let numValoresPositivos = [];

    for (let i = 0; i < array.length; i++) {
        if (array[i] > 0) {
            numValoresPositivos.push(array[i]);
        }
    }
    array.pop();
    array.push(numValoresPositivos.length);
    return array;
}
console.log("Sus valores han sido modificados exitosamente", contarPositivos([-1,1,1,1])); //debe devolver [-1,1,1,3]

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 6");
//Pares e Impares - Crea una función que acepte un array. Cada vez que ese array tenga 3 valores impares seguidos, imprime (print) “¡Qué imparcial!”, y cada vez que tenga 3 pares seguidos, imprime (print) “¡Es para bien!”.

function valSeguidos(array) {
    let impares = 0;
    let pares = 0;

    for (let i = 0; i < array.length; i++) {
        if (array[i] % 2 != 0) {
            impares++;
            pares = 0;
            if (impares === 3) {
                console.log("¡Qué imparcial!");
                impares = 0;
            }
        } else {
            pares++;
            impares = 0;
            if (pares === 3) {
                console.log("¡Es para bien!");
                pares = 0;
            }
        }
    }
}
console.log(valSeguidos([3,5,-11,2,10,-18,-5,20,13,19]));

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 7");
//Dado un array de números llamado arr, suma 1 a los elementos, específicamente a aquellos cuyo índice es impar (arr[1], arr[3], arr[5], etc). Luego, imprime (console.log) cada valor del array y devuelve el arreglo arr.

function sumarUno(arr) {
    for (let i = 0; i < arr.length; i++) {
        if (i % 2 == 0) {
            console.log("Su índice es par y el elemento se mantiene:", arr[i]);
        }
        else{
            arr[i] = arr[i] + 1;
            console.log("Su índice es impar y al elemento se le suma uno:", arr[i]);
        }
    }
    return arr;
}
console.log("El conjunto de valores sería:",sumarUno([1,2,3,4,5]));// debe devolver [1,3,3,5,5]

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 8 (no completado)");
//Longitudes previas - Pasado un array (similar a decir ‘tomado un array’ o ‘dado un array’) que contiene strings, reemplaza cada string con un número de acuerdo cantidad de letras (longitud) del string anterior. Por ejemplo, longitudesPrevias([“programar”,“dojo”, “genial”]) debería devolver [“programar”,9, 4]. Pista: ¿For loops solo puede ir hacia adelante?


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 9");
//Agrega Siete - Construye una función que acepte un array. Devuelve un nuevo array con todos los valores del original, pero sumando 7 a cada uno. No alteres el array original. Por ejemplo, agregaSiete([1,2,3]) debería devolver [8,9,10] en un nuevo array. 

function agregaSiete(array) {
    let nuevoArray = [];

    for (let i = 0; i < array.length; i++) {
        array[i] += 7;
        nuevoArray.push(array[i]);
    }
    return nuevoArray;
}
console.log("A cada valor se le ha sumado 7:", agregaSiete([1,2,3])); //debe devolver [8,9,10]

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 10 (no completado)");
//Array Inverso - Dado un array, escribe una función que invierte sus valores en el lugar. Ejemplo: invertir([3,1,6,4,2)) devuelve el mismo array pero con sus valores al revés, es decir [2,4,6,1,3]. Haz esto sin crear un array temporal vacío. (Pista: necesitarás intercambiar (swap) valores).

function invertir(array) {
    for (let i = array.length - 1; i < 0; i--) {
        array.push(array[i]);
    }
    return array;
}
console.log(invertir([3,1,6,4,2]));

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 11");
//Perspectiva: Negativa - Dado un array crear y devuelve uno nuevo que contenga todos los valores del array original, pero negativos (no simplemente multiplicando por -1). Dado [1,-3,5], devuelve [-1,-3,-5].

function devolverNegativos(array) {
    let nuevoArr = [];

    for (let i = 0; i < array.length; i++) {
        if (array[i] >= 0) {
            array[i] = array[i] * -1;
            nuevoArr.push(array[i]);
        } else {
            nuevoArr.push(array[i]);
        }
    }
    return nuevoArr;
}
console.log("Los valores han sido cambiados a negativos",devolverNegativos([1,-3,5])); //debe devolver [-1,-3,-5]

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 12 (no completado)");
//Siempre hambriento - Crea una función que acepte un array e imprima (print) “yummy” cada vez que alguno de los valores sea “comida”. Si ningún valor es “comida”, entonces imprime “tengo hambre” una vez. 

function imprimirYummy(array) {
    for (let i = 0; i < array.length; i++) {
        if (array[i] === "comida") {
            console.log("yummy");
        }
    }
    return array;
}
console.log(imprimirYummy(["casa","comida","agua","comida"]));

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 13 (no completado");
//Cambiar hacia el centro -  Dado un array, cambia el primer y último valor, el tercero con el ante penútimo, etc. Ejemplo: cambiaHaciaElCentro([true, 42, “Ada”, 2, “pizza”]) cambia el array a [“pizza¨, 42, “Ada”, 2, true]. cambiaHaciaElCentro([1,2,3,4,5,6]) cambia el array a [6,2,4,3,5,1]. No es necesario devolver (return) el array esta vez. 



//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 14");
//Escala el Array - Dado un array arr y un número num, multiplica todos los valores en el array arr por el número num, y devuelve el array arr modificado. Por ejemplo, escalaArray([1,2,3], 3] debería devolver [3,6,9].

function escalaArray(array, num) {
    for (let i = 0; i < array.length; i++) {
        array[i] *= num;
    }
    return array;
}
console.log(escalaArray([1,2,3], 3)); //debe devolver [3,6,9]