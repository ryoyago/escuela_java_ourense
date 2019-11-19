function operarArrays(arrX, arrY, operaCllbk) {
    //Comprobamos que el tamaño de los arrrays son el mismo 
    if (arrX.length == arrY.length) {
        //Declaramos array con la palabra va: ambito es de funcion
        //A diferencia de let de  ES6, que si es ambito a nivel bloque
        var arrayResultado = new Array(arrX.length); // Una manera de crear array
        for(let i = 0; i< arrX.length;i++){
            arrayResultado[i]=operaCllbk(arrX[i], arrY[i]);
        }

    }
    return arrayResultado;
}

//Declaramos array de ejemplos
//var arrayResultado = new Array(); // Una manera de crear array
var arrayEjemplo = []; // Otra manera con notacion JSON
// No indicamos el tamaño, por que en realidad los array de JS 
// son como los arrayList<Object>  de Java
arrayEjemplo.push("Primer elemento");
arrayEjemplo[10] = "lo que sea";