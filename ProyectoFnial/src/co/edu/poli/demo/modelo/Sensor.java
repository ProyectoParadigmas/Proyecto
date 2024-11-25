package co.edu.poli.demo.modelo;

/**
 * Clase que representa un sensor asociado a un semáforo.
 * Los sensores permiten recopilar información del entorno
 * para la toma de decisiones inteligentes.
 */
public class Sensor {

    /**
     * Identificador único del sensor.
     */
    private String idSensor;

    /**
     * Tipo de sensor (por ejemplo, infrarrojo, de movimiento, de luz, etc.).
     */
    private String tipoSensor;

    /**
     * Constructor de la clase Sensor.
     * 
     * @param idSensor   Identificador único del sensor.
     * @param tipoSensor Tipo de sensor asociado.
     */
    public Sensor(String idSensor, String tipoSensor) {
        setIdSensor(idSensor);
        setTipoSensor(tipoSensor);
    }

    /**
     * Obtiene el identificador único del sensor.
     * 
     * @return ID del sensor.
     */
    public String getIdSensor() {
        return idSensor;
    }

    /**
     * Establece el identificador único del sensor.
     * 
     * @param idSensor Nuevo identificador para el sensor.
     */
    public void setIdSensor(String idSensor) {
        if (idSensor != null && !idSensor.isEmpty()) {
            this.idSensor = idSensor;
        } else {
            throw new IllegalArgumentException("El idSensor no puede ser nulo o vacío.");
        }
    }

    /**
     * Obtiene el tipo de sensor.
     * 
     * @return Tipo del sensor.
     */
    public String getTipoSensor() {
        return tipoSensor;
    }

    /**
     * Establece el tipo de sensor.
     * 
     * @param tipoSensor Nuevo tipo para el sensor.
     */
    public void setTipoSensor(String tipoSensor) {
        if (tipoSensor != null && !tipoSensor.isEmpty()) {
            this.tipoSensor = tipoSensor;
        } else {
            throw new IllegalArgumentException("El tipoSensor no puede ser nulo o vacío.");
        }
    }

    /**
     * Activa el sensor y simula la obtención de datos del entorno.
     */
    public void activarSensor() {
        System.out.println("Sensor " + idSensor + " activado, tipo: " + tipoSensor);
        // Aquí podrías agregar más lógica si es necesario
    }

    /**
     * Genera una representación en formato texto de los atributos del sensor.
     * 
     * @return Una cadena con el identificador y tipo del sensor.
     */
    @Override
    public String toString() {
        return "Sensor [idSensor=" + idSensor + ", tipoSensor=" + tipoSensor + "]";
    }
}
