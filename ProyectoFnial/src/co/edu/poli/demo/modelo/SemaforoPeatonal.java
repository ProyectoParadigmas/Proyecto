package co.edu.poli.demo.modelo;

/**
 * Clase que representa un semáforo peatonal, extendiendo la funcionalidad
 * de un semáforo inteligente. Incluye tiempos específicos para las luces
 * dirigidas a los peatones.
 */
public class SemaforoPeatonal extends SemaforoInteligente {

    /**
     * Tiempo que la luz verde permanece activa para los peatones (en segundos).
     */
    private double tiempoVerdePeaton;

    /**
     * Tiempo que la luz roja permanece activa para los peatones (en segundos).
     */
    private double tiempoRojoPeaton;

    /**
     * Constructor de la clase Semáforo Peatonal.
     * 
     * @param idSemaforo        Identificador único del semáforo.
     * @param ubicacion         Ubicación donde está instalado el semáforo.
     * @param estado            Estado inicial del semáforo.
     * @param sensor            Sensor asociado al semáforo.
     * @param tiempoVerdePeaton Tiempo en segundos que la luz verde estará activa para peatones.
     * @param tiempoRojoPeaton  Tiempo en segundos que la luz roja estará activa para peatones.
     */
    public SemaforoPeatonal(String idSemaforo, String ubicacion, String estado, Sensor sensor, 
                            double tiempoVerdePeaton, double tiempoRojoPeaton) {
        super(idSemaforo, ubicacion, estado, sensor);
        this.tiempoVerdePeaton = tiempoVerdePeaton;
        this.tiempoRojoPeaton = tiempoRojoPeaton;
    }

    /**
     * Obtiene el tiempo de duración de la luz verde para peatones.
     * 
     * @return Tiempo en segundos de la luz verde para peatones.
     */
    public double getTiempoVerdePeaton() {
        return tiempoVerdePeaton;
    }

    /**
     * Establece el tiempo de duración de la luz verde para peatones.
     * 
     * @param tiempoVerdePeaton Nuevo tiempo (en segundos) para la luz verde.
     */
    public void setTiempoVerdePeaton(double tiempoVerdePeaton) {
        this.tiempoVerdePeaton = tiempoVerdePeaton;
    }

    /**
     * Obtiene el tiempo de duración de la luz roja para peatones.
     * 
     * @return Tiempo en segundos de la luz roja para peatones.
     */
    public double getTiempoRojoPeaton() {
        return tiempoRojoPeaton;
    }

    /**
     * Establece el tiempo de duración de la luz roja para peatones.
     * 
     * @param tiempoRojoPeaton Nuevo tiempo (en segundos) para la luz roja.
     */
    public void setTiempoRojoPeaton(double tiempoRojoPeaton) {
        this.tiempoRojoPeaton = tiempoRojoPeaton;
    }

    /**
     * Sobrescribe el método para indicar el tipo de semáforo.
     * 
     * @return El tipo de semáforo, que es "Peatonal".
     */
    @Override
    public String tipoSemaforo() {
        return "Peatonal";
    }

    /**
     * Representación textual de los atributos del semáforo peatonal.
     * 
     * @return Una cadena con los valores del tiempo de luz verde y roja,
     * además de los atributos heredados.
     */
    @Override
    public String toString() {
        return "SemaforoPeatonal [idSemaforo=" + getIdSemaforo() + ", ubicacion=" + getUbicacion() + 
               ", estado=" + getEstado() + ", tiempoVerdePeaton=" + tiempoVerdePeaton + 
               ", tiempoRojoPeaton=" + tiempoRojoPeaton + ", sensor=" + getSensor() + "]";
    }
}
