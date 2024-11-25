package co.edu.poli.demo.servicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import co.edu.poli.demo.modelo.SemaforoInteligente;

/**
 * Implementación de la interfaz Operacion que proporciona operaciones CRUD
 * para manejar objetos SemaforoInteligente, incluyendo la serialización y
 * deserialización.
 */
public class ImplementacionOperacion implements Operacion {

    /**
     * Array de objetos SemaforoInteligente para almacenar semáforos vehiculares.
     */
    private SemaforoInteligente[] Semaforo;

    /**
     * Constructor que inicializa el array de semáforos vehiculares con un tamaño
     * inicial de 1.
     */
    public ImplementacionOperacion() {
    	Semaforo = new SemaforoInteligente[1];
    }

    /**
     * Establece el array de semáforos vehiculares.
     * 
     * @param SemaforoVehicular Array de semáforos vehiculares.
     */
    public void setSemaforoVehicular(SemaforoInteligente[] SemaforoVehicular) {
        this.Semaforo = SemaforoVehicular;
    }

    /**
     * Crea y guarda un nuevo semáforo inteligente en el array.
     * Si el array está lleno, duplica su tamaño y agrega el nuevo semáforo.
     * 
     * @param nuevoSemaforo El nuevo semáforo a guardar.
     * @return Mensaje de confirmación.
     */
    public String create(SemaforoInteligente semaforo) {
        for (int i = 0; i < Semaforo.length; i++) {
            if (Semaforo[i] == null) {
            	Semaforo[i] = semaforo;
                return "Save!";
            }
        }
        // Si el array está lleno, duplicamos su tamaño
        SemaforoInteligente[] SemaforoInt = new SemaforoInteligente[Semaforo.length * 2];
        System.arraycopy(Semaforo, 0, SemaforoInt, 0, Semaforo.length);
        SemaforoInt[Semaforo.length] = semaforo;
        Semaforo = SemaforoInt;
        return "Save!!";
    }

    /**
     * Lee un semáforo inteligente en base a su código de identificación.
     * 
     * @param id El código del semáforo a buscar.
     * @return El semáforo encontrado, o null si no se encuentra.
     */
    public SemaforoInteligente read(String id) {
        for (int i = 0; i < Semaforo.length; i++) {
            if (!(Semaforo[i] == null))
                if (Semaforo[i].getCodigo().equals(id))
                    return Semaforo[i];
        }
        return null;
    }

    /**
     * Devuelve todos los semáforos inteligentes almacenados en el array.
     * 
     * @param all Parámetro adicional que no se utiliza, pero se conserva para
     *            compatibilidad.
     * @return Todos los semáforos inteligentes.
     */
    public SemaforoInteligente[] read1() {
        return Semaforo;
    }

    /**
     * Actualiza un semáforo inteligente existente basado en su código de
     * identificación.
     * 
     * @param id              El código del semáforo a actualizar.
     * @param nuevoSemaforo   El nuevo semáforo con la información actualizada.
     * @return Mensaje de confirmación si se actualizó correctamente o un mensaje
     *         de error si no se encontró el semáforo.
     */
    public String update(String id, SemaforoInteligente nuevoSemaforo) {
        for (int i = 0; i < Semaforo.length; i++) {
            if (!(Semaforo[i] == null))
                if (Semaforo[i].getCodigo().equals(id)) {
                	Semaforo[i] = nuevoSemaforo;
                    return "Update!";
                }
        }
        return "Cod is not in the array!";
    }

    /**
     * Elimina un semáforo inteligente en base a su código de identificación.
     * 
     * @param id El código del semáforo a eliminar.
     * @return El semáforo eliminado, o null si no se encuentra.
     */
    public SemaforoInteligente delete(String id) {
        SemaforoInteligente temp = null;
        for (int i = 0; i < Semaforo.length; i++) {
            if (!(Semaforo[i] == null))
                if (Semaforo[i].getCodigo().equals(id)) {
                    temp = Semaforo[i];
                    Semaforo[i] = null;
                    return temp;
                }
        }
        return temp;
    }

    /**
     * Serializa el array de semáforos inteligentes y lo guarda en un archivo.
     * 
     * @param semaforoInteligente El array de semáforos a serializar.
     * @param path               La ruta donde guardar el archivo.
     * @param name               El nombre del archivo.
     * @return Mensaje de éxito o error según el resultado de la operación.
     */
    public String serializar(SemaforoInteligente[] semaforoInteligente, String path, String name) {
        try {
            FileOutputStream fos = new FileOutputStream(path + name);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Semaforo);
            oos.close();
            fos.close();
            return "File create!!";
        } catch (IOException ioe) {
            return "Error file " + ioe.getMessage();
        }
    }

    /**
     * Deserializa el contenido de un archivo y lo convierte en un array de
     * semáforos inteligentes.
     * 
     * @param path La ruta del archivo a deserializar.
     * @param name El nombre del archivo a deserializar.
     * @return El array de semáforos deserializados.
     */
    public SemaforoInteligente[] deserializar(String path, String name) {
        SemaforoInteligente[] a = null;
        try {
            FileInputStream fis = new FileInputStream(path + name);
            ObjectInputStream ois = new ObjectInputStream(fis);
            a = (SemaforoInteligente[]) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        } catch (ClassNotFoundException c) {
            System.err.println(c.getMessage());
        }
        return a;
    }

	
	}

