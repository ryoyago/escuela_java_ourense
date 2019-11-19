let array_A = [1,2,3,4,5];
let array_B = [2,3,4,5,6];

let arraySumaAB = operarArrays(array_A, array_B, suma);
arrayEnTabla(arraySumaAB);

let arrayMultAB = operarArrays(array_A, array_B, multiplica);
arrayEnTabla(arrayMultAB);

let arrayDiviAB= operarArrays(array_A,array_B,divide);
arrayEnTabla(arrayDiviAB);

let arrayRestaAB= operarArrays(array_A,array_B,resta);
arrayEnTabla(arrayRestaAB);

let arrayPrueba=operarArrays(array_A,array_B, prueba);
arrayEnTabla(arrayPrueba);




function arrayEnTabla(array){
    let tabla = "<table border=2><tr>";
        for (let index = 0; index < array.length; index++) {
            const element = array[index];
            tabla += "<td>&nbsp" + element + "&nbsp</td>";
        }
        document.getElementById("contenido").innerHTML+= tabla + "</tr></table>";
}