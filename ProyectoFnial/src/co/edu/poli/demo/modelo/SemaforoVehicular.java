package co.edu.poli.demo.modelo;

/**
 * Clase que representa un semáforo vehicular, extendiendo la funcionalidad
 * de un semáforo inteligente. Este semáforo está diseñado para gestionar
 * el tráfico de vehículos y contiene información sobre el número de carriles
 * que regula.
 */
public class SemaforoVehicular extends SemaforoInteligente {

    /**
     * Número de carriles que regula el semáforo vehicular.
     */
    private int numeroCarriles;

    /**
     * Constructor de la clase Semáforo Vehicular.
     * 
     * @param idSemaforo    Identificador único del semáforo.
     * @param ubicacion     Ubicación donde está instalado el semáforo.
     * @param estado        Estado inicial del semáforo.
     * @param sensor        Sensor asociado al semáforo.
     * @param numeroCarriles Número de carriles que regula este semáforo.
     */
    public SemaforoVehicular(String idSemaforo, String ubicacion, String estado, Sensor sensor, int numeroCarriles) {
        super(idSemaforo, ubicacion, estado, sensor);
        this.numeroCarriles = numeroCarriles;
    }

    /**
     * Obtiene el número de carriles que regula el semáforo vehicular.
     * 
     * @return Número de carriles.
     */
    public int getNumeroCarriles() {
        return numeroCarriles;
    }

    /**
     * Establece el número de carriles que regula el semáforo vehicular.
     * 
     * @param numeroCarriles Nuevo número de carriles.
     */
    public void setNumeroCarriles(int numeroCarriles) {
        this.numeroCarriles = numeroCarriles;
    }

    /**
     * Sobrescribe el método para indicar el tipo de semáforo.
     * 
     * @return El tipo de semáforo, que es "Vehicular".
     */
    @Override
    public String tipoSemaforo() {
        return "Vehicular";
    }

    /**
     * Genera una representación textual de los atributos del semáforo vehicular.
     * 
     * @return Una cadena que describe los atributos del semáforo vehicular.
     */
    @Override
    public String toString() {
        return "SemaforoVehicular [idSemaforo=" + getIdSemaforo() + ", ubicacion=" + getUbicacion() + 
               ", estado=" + getEstado() + ", numeroCarriles=" + numeroCarriles + 
               ", sensor=" + getSensor() + "]";
    }
}
