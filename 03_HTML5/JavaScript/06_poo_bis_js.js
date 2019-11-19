var divBis = document.getElementById("contenido_bis");
divBis.style = "background-color: lightgrey";

var mostrarTodosParam = function(primerParam){
    divBis.innerHTML+="<P>Primer parámetro: "+primerParam + "</p>";
  for (argumento of arguments) {
      divBis.innerHTML+="Argumento: " + argumento  + "</br>";
  }
  if(typeof(primerParam)=== "undefined")
  divBis.innerHTML+="primerParam no está definida";

  if(primerParam == "1"){
      divBis.innerHTML+="Es parecido\"1\"";
  }else{
    divBis.innerHTML+="No es parecido \"1\"";
  }
  if(primerParam === "1"){
    divBis.innerHTML+="Es identico\"1\"";
}else{
  divBis.innerHTML+="No es identico \"1\"";
}

}

mostrarTodosParam("Un parámetro", 50, true, bebida);
mostrarTodosParam();
mostrarTodosParam("1");//Le pasamos un texto xon un 1
mostrarTodosParam(1); // Valor de tipo number

var intentoConversion = parseFloat("veinte"); // Muestra NaN, not a number
divBis.innerHTML+= "<br/>Convirtiendo. Resultado = " + (intentoConversion);
divBis.innerHTML+="<br/>El tipo de dato es " + typeof(intentoConversion);
if(isNaN(divBis)) divBis.innerHTML+="<br/>No es un numero";
divBis.innerHTML+="<br/>Infinito: " + 1/0;

//Precision double parece. 

divBis.innerHTML+="<br/>Valor max: " + 1.234567890123456789;

