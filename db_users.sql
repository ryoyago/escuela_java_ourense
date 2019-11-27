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

DAOUsuariosDerby

C -> Crear nuevo (Insert)	
R -> Leer uno por Id, Leer todos, (Leer por email) (SELECT)
U -> Actualizar por Id	(o email)
D -> Eliminar por Id (o email)

ServicioUsuarios  (puede o no implementar IGenericDao<T>):
 + validarDatos(....){}
	* Nombre e email de más de 1 letra, menos de lo permitido en bbdd
	* Edad: Recibir un String, convertir en número y comprobar que > 12 años
	* Email que realmente sea un email y Nombre también (usar reg exp).
	* Password mínimo 4 caracteres
 + Usuario crear(String email, String password, String nombre, String edad){}
	Debe devolver el USUARIO COMPLETO, incluido el ID generado en bbdd.
 + Usuario modificar(int Id, String email, String password, String nombre, String edad){ }	
 + Usuario modificar(Usuario usuDatosNuevos) {   /*Invocar al anterior*/}
 + boolean eliminar(int id)
 + Usuario leerUno(int id)
 + Usuario leerUno(String email)	
 + List<Usuario> leerPorNombre(String nombre)  (si nombre es vacío, devuelve todos)
 + List<Usuario> leerTodos()

TESTS Modelo Usuario:
@Test +crearUsuariosInvalidos() { /* Crear 5 usuarios no válidos y comprobar que no se han insertado */   }
@Test +crearUsuariosValidos() {	/* Crear 5 usuarios válidos y comprobar que existen y eliminarlos */ } 
- Otros 2 tests para modificar y eliminar

