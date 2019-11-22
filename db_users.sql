CREATE TABLE usuario (
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY 
		(START WITH 1, INCREMENT BY 1),
	email VARCHAR(255) NOT NULL,
	password VARCHAR(50) NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	age INTEGER NOT NULL,
	CONSTRAINT primary_key PRIMARY KEY(id),
	CONSTRAINT unique_email UNIQUE(email)
)
DAO Usuarios implements IGenericDao<T>: Recibe y envía objetos

C -> Crear nuevo (Insert)	
R -> Leer uno por Id, Leer todos, (Leer por email) (SELECT)
U -> Actualizar por Id	(o email)
D -> Eliminar por Id (o email)

ServicioUsuarios  (puede o no implementar IGenericDao<T>):
 + validarDatos(....){}
 + Usuario crear(String email, String password, String nombre, int edad){}
 + Usuario modificar(int Id, String email, String password, String nombre, int edad){}	
 + Usuario modificar(Usuario usuDatosNuevos) {   /*Invocar al anterior*/}
 + boolean eliminar(int id)
 + Usuario leerUno(int id)
 + Usuario leerUno(String email)	
 + List<Usuario> leerPorNombre(String nombre)  (si nombre es vacío, devuelve todos)
 + List<Usuario> leerTodos()




