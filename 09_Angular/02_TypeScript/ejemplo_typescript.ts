
var lenguaje = "JavaScript";
console.log("TypeScript es " + lenguaje);

let textoExtra: String = " con Tipo fuerte OPCIONAL ";


console.log("TypeScript es " + lenguaje+ textoExtra);

class UnaClase{
	private propiedad: String;
	constructor( private propiedad: String){
		
		
	}
	public getPropiedad() : String{
		return this.propiedad;
	}
}

let unObjeto: UnaClase= new UnaClase("Tiene POO");

textoExtra = 2000;

console.log("Y " + unObjeto.getPropiedad());