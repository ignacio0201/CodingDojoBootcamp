console.log("Ejercicio 1");
//Obtén del 1 al 255: Escribe una función que devuelve un array con todos los números del 1 al 255.


function numeros(x) {
    let arr = [];

    for (let i = 1; i <= 255; i++) {
        arr.push(i);
    }
    return arr;
}
console.log("Todos los números del 1 al 255 son:", numeros());

//--------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 2");
//Consigue pares hasta 1000: Escribe una función que entregue la suma de todos los números pares del 1 al 1000 - Puedes usar un operador de módulo para este ejercicio.

function sumaPares(x) {
    let sumaTotal = 0;

    for (let i = 1; i <= 1000; i++) {
        if (i % 2 === 0) {
            sumaTotal = sumaTotal + i;
        }
    }
    return sumaTotal;
}
console.log("La suma total de los pares entre 1 y 1000 es:", sumaPares());

//--------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 3");
//Suma impares hasta 5000: Escribe una función que devuelva la suma de todos los números impares entre 1 y 5000 (ej: 1+3+5+...+4997+4999).

function sumaImpares(x) {
    let sumaTotal = 0;

    for (let i = 1; i <= 5000; i++) {
        if (i % 2 === 1) {
            sumaTotal = sumaTotal + i;
        }
    }
    return sumaTotal
}
console.log("La suma total de los impares entre 1 y 5.000 es:", sumaImpares());

//--------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 4");
//Itera un array: Escribe una función que devuelva la suma de todos los valores dentro de un array (ej:  [1,2,5] retorna 8. [-5,2,5,12] retorna 14). 

function sumaArr(x) {
    let sumaTotal = 0;

    for (let i = 0; i < x.length; i++) {
        sumaTotal = sumaTotal + x[i];
    }
    return sumaTotal;
}
console.log("La suma total es:", sumaArr([1,2,5])); //debe retornar 8

//--------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 5");
//Encuentra el mayor (max): Dado un array con múltiples valores, escribe una función que devuelva el número mayor (ej: para [-3,3,5,7] el número mayor (max) es 7). 

function numMayor(x) {
    let max = 0;

    for (let i = 0; i < x.length; i++) {
        if (x[i] > max){
            max = x[i];
        }
    }
    return max;
}
console.log("El número mayor es:", numMayor([-3,3,5,7])); //debe retornar 7

//--------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 6");
//Encuentra el promedio (avg): Dado un array con múltiples valores, escribe una función que devuelva el promedio de los valores (ej: para [1,3,5,7,20] el promedio es 7.2).

function calcularPromedio(x) {
    let sumaPromedio = 0;
    let promedio = 0;

    for (let i = 0; i < x.length; i++) {
        sumaPromedio = sumaPromedio + x[i];
    }
    promedio = sumaPromedio/x.length;
    return promedio;
}
console.log("El promedio es:", calcularPromedio([1,3,5,7,20])); //debe devolver 7.2

//--------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 7");
//Array de impares: Escribe una función que devuelva un array de todos los números impares entre 1 y 50 (ej: [1,3,5, …, 47,49]). Pista: Usa el método ‘push’.

function numImpares(x) {
    let impares = [];

    for (let i = 1; i <= 50; i++) {
        if (i % 2 === 1) {
            impares.push(i);
        }
    }
    return impares;
}
console.log(numImpares());

//--------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 8");
//Dado un valor Y, escribe una función que toma un array y devuelve los valores mayores que Y. Por ejemplo, si arr = [1,3,5,7] y Y = 3, tu función devolverá 2 (hay 2 números en el array mayores que 3, esto son 5 y 7). 

function mayoresQueY(arr) {
    let Y = 3;
    let arrModificado = [];

    for (let i = 0; i < arr.length; i++) {
        if (arr[i] > Y) {
            arrModificado.push(arr[i]);
        }
    }
    return arrModificado;
}
console.log(mayoresQueY([1,3,5,7])); //debe devolver 5 y 7

//--------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 9");
//Cuadrados: Dado un array con múltiples valores, escribe una función que reemplace cada valor por el cuadrado del mismo valor (ej: [1,5,10,-2] será [1,25,100,4]).

function calcularCuadrado(x) {
    let arrCuadrado = [];

    for (let i = 0; i < x.length; i++) {
        arrCuadrado.push(x[i]*x[i]);
    }
    return arrCuadrado;
}
console.log(calcularCuadrado([1,5,10,-2])); //debe devolver [1,25,100,4]

//--------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 10");
//Negativos: Dado un array con múltiples valores, escribe una función que reemplace cualquier número negativo dentro del array por 0. Cuando el programa esté listo, el array no debiera contener números negativos (ej: [1,5,10,-2] se convertirá en [1,5,10,0]).

function reemplazarNegativos(x) {
    let arrSinNegativos = [];

    for (let i = 0; i < x.length; i++) {
        if (x[i] > 0) {
            arrSinNegativos.push(x[i])
        }
        else {
            x[i] = 0;
            arrSinNegativos.push(x[i])
        }
    }
    return arrSinNegativos;
}
console.log(reemplazarNegativos([1,5,10,-2])); //debe devolver [1,5,10,0]

//--------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 11");
//Max/Min/Avg: Dado un array con múltiples valores, escribe una función que devuelva un nuevo array que solo contenga el valor mayor (max), menor (min) y promedio (avg) del array original (ej: [1,5,10,-2] devolverá [10,-2,3.5]).

function calcularMaxMinAvg(array) {
    let max = array[0];
    let min = array[0];
    let sumaTotal = 0;
    let promedio = 0;
    let nuevoArr = []

    for (let i = 0; i < array.length; i++) {
        sumaTotal += array[i];
        if (array[i] > max){
            max = array[i];
        }
        if (array[i] < min){
            min = array[i];
        }
    }
    promedio = sumaTotal / array.length;
    nuevoArr.push(max, min, promedio);
    return nuevoArr;
}
console.log(calcularMaxMinAvg([1,5,10,-2])); //debe devolver [10,-2,3.5]

//--------------------------------------------------------------------------------------------------------------------------------------------//

console.log("Ejercicio 12");
//Escribe una función que intercambie el primer y el último valor de cualquier array. La extensión mínima predeterminada del array es 2 (ej: [1,5,10,-2] será [-2,5,10,1]). 

function intercambiarValores(array) {
    if (array < 2) {
        console.log("Mínimo debe contener dos valores");
    }
    else {
        let temp = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = temp;
    }
    return array;
}
console.log(intercambiarValores([1,5,10,-2])); //debe devolver [-2,5,10,1])

//--------------------------------------------------------------------------------------------------------------------------------------------//
console.log("Ejercicio 13");
//De Número a String: Escribe una función que tome un array de números y reemplace cualquier valor negativo por el string ‘Dojo’. Por ejemplo, dado el array = [-1,-3,2], tu función devolverá [‘Dojo’,‘Dojo’,2].

function reemplazoNegativosString(array) {
    for (let i = 0; i < array.length; i++) {
        if (array[i] < 0) {
            array[i] = "Dojo"
        }
    }
    return array;
}
console.log(reemplazoNegativosString([-1,-3,2])); //debe devolver [‘Dojo’,‘Dojo’,2]
