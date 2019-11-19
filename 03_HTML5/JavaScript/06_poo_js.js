var div=document.getElementById("contenido");

var bebida = new Object();

bebida.tipo="Cerveza";
bebida.cantidad="3 litros";


div.innerHTML+="Bebida es " + bebida.tipo + "<br/>";

//En js, los objetos son mapàs
//(como en el hashmap)
div.innerHTML+="Cantidad es " + bebida["cantidad"];

bebida["propiedades"] = "Tiene alcohol, gas y emborrracha";
div.innerHTML+="<br/>Propiedades: " + bebida.propiedades;


function suma(x,y){
    return x + y;

}

div.innerHTML+= "</br>suma(5,3)= "+ suma(5,3);
div.innerHTML+= "</br>suma('5','3')= "+ suma('5','3');

// hPara hace una especie clase, solo creamos una funcion constructora
function Bebida(tipo, cant,prop){
    this.tipo=tipo;
    this.cantidad=cant;
    this.propiedades=prop;  

    function funMostrar(){
        div.innerHTML+= "<p>Bebida: " + this.tipo + " , " + this.cantidad + " , " + this.propiedades;
    }

    this.mostrar=funMostrar;
}

var zumo = new Bebida("zumo de naranja", "1 L" ,"Vitamina C" );

zumo.mostrar();

