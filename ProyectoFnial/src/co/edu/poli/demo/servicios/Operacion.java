package co.edu.poli.demo.servicios;

import co.edu.poli.demo.modelo.SemaforoInteligente;


/**
 * Interfaz que define las operaciones CRUD (crear, leer, actualizar, eliminar) 
 * y las operaciones de serialización y deserialización para la clase SemaforoInteligente.
 */
public interface Operacion {

    /**
     * Crea un nuevo semáforo inteligente y lo guarda en el almacenamiento.
     * 
     * @param x El semáforo inteligente a crear.
     * @return Mensaje que indica el resultado de la operación.
     */
    public String create(SemaforoInteligente x);

    /**
     * Lee un semáforo inteligente dado su identificador.
     * 
     * @param id El identificador del semáforo inteligente.
     * @return El semáforo inteligente encontrado, o null si no se encuentra.
     */
    public SemaforoInteligente read(String id);

    /**
     * Lee todos los semáforos inteligentes.
     * 
     * @param all Parámetro que indica que se deben leer todos los semáforos.
     * @return Un array con todos los semáforos inteligentes.
     */
    public SemaforoInteligente[] read1();

    /**
     * Actualiza un semáforo inteligente existente dado su identificador.
     * 
     * @param id El identificador del semáforo inteligente a actualizar.
     * @param nuevoSemaforo El nuevo semáforo inteligente con los cambios.
     * @return Mensaje que indica el resultado de la operación.
     */
    public String update(String id, SemaforoInteligente x);

    /**
     * Elimina un semáforo inteligente dado su identificador.
     * 
     * @param id El identificador del semáforo inteligente a eliminar.
     * @return El semáforo inteligente eliminado, o null si no se encontraba.
     */
    public SemaforoInteligente delete(String id);

    /**
     * Serializa el array de semáforos inteligentes a un archivo en el sistema de almacenamiento.
     * 
     * @param semaforoInteligente El array de semáforos inteligentes a serializar.
     * @param path La ruta del archivo donde se almacenará la serialización.
     * @param name El nombre del archivo.
     * @return Mensaje que indica si la operación fue exitosa o si ocurrió un error.
     */
    public String serializar(SemaforoInteligente[] semaforoInteligente, String path, String name);

    /**
     * Deserializa el archivo que contiene los semáforos inteligentes y los carga en un array.
     * 
     * @param path La ruta del archivo donde se encuentra la serialización.
     * @param name El nombre del archivo que se deserializará.
     * @return El array de semáforos inteligentes deserializado, o null si ocurrió un error.
     */
    public SemaforoInteligente[] deserializar(String path, String name);
}

