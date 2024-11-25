package co.edu.poli.demo.modelo;

/**
 * Clase que representa los datos de tráfico gestionados por el sistema.
 * 
 * <p>Esta clase modela la información básica relacionada con el tráfico vehicular, 
 * incluyendo el flujo vehicular y la velocidad promedio. Es útil para representar 
 * estos datos en interfaces JavaFX, como tablas o gráficos.</p>
 */
public class DatosTrafico {

    /**
     * Identificador único de los datos de tráfico.
     */
    private String idTrafico;

    /**
     * Flujo vehicular medido en el área (vehículos por unidad de tiempo).
     */
    private double flujoVehicular;

    /**
     * Velocidad promedio de los vehículos en la zona monitoreada (en km/h).
     */
    private double velocidadPromedio;

    /**
     * Constructor que inicializa los datos de tráfico con su identificador, flujo vehicular y velocidad promedio.
     * 
     * @param idTrafico Identificador único de los datos de tráfico.
     * @param flujoVehicular Flujo vehicular medido.
     * @param velocidadPromedio Velocidad promedio de los vehículos.
     */
    public DatosTrafico(String idTrafico, double flujoVehicular, double velocidadPromedio) {
        super();
        this.idTrafico = idTrafico;
        this.flujoVehicular = flujoVehicular;
        this.velocidadPromedio = velocidadPromedio;
    }

    /**
     * Obtiene el identificador de los datos de tráfico.
     * 
     * @return El identificador único de los datos de tráfico.
     */
    public String getIdTrafico() {
        return idTrafico;
    }

    /**
     * Establece el identificador de los datos de tráfico.
     * 
     * @param idTrafico El identificador único de los datos de tráfico.
     */
    public void setIdTrafico(String idTrafico) {
        this.idTrafico = idTrafico;
    }

    /**
     * Obtiene el flujo vehicular registrado.
     * 
     * @return El flujo vehicular.
     */
    public double getFlujoVehicular() {
        return flujoVehicular;
    }

    /**
     * Establece el flujo vehicular registrado.
     * 
     * @param flujoVehicular El flujo vehicular.
     */
    public void setFlujoVehicular(double flujoVehicular) {
        this.flujoVehicular = flujoVehicular;
    }

    /**
     * Obtiene la velocidad promedio de los vehículos registrados.
     * 
     * @return La velocidad promedio.
     */
    public double getVelocidadPromedio() {
        return velocidadPromedio;
    }

    /**
     * Establece la velocidad promedio de los vehículos registrados.
     * 
     * @param velocidadPromedio La velocidad promedio.
     */
    public void setVelocidadPromedio(double velocidadPromedio) {
        this.velocidadPromedio = velocidadPromedio;
    }

    /**
     * Actualiza los datos de tráfico con nuevos valores de flujo vehicular y velocidad promedio.
     * 
     * @param flujo Nuevo valor de flujo vehicular.
     * @param velocidad Nuevo valor de velocidad promedio.
     */
    public void actualizarDatos(double flujo, double velocidad) {
        this.flujoVehicular = flujo;
        this.velocidadPromedio = velocidad;
    }

    /**
     * Representación en formato de cadena de texto de los datos de tráfico.
     * 
     * @return Una cadena que representa los datos de tráfico, incluyendo identificador, flujo vehicular y velocidad promedio.
     */
    @Override
    public String toString() {
        return "DatosTrafico [idTrafico=" + idTrafico + ", flujoVehicular=" + flujoVehicular + ", velocidadPromedio="
                + velocidadPromedio + "]";
    }
}
