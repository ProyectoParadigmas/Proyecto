package co.edu.poli.demo.modelo;

import java.util.Arrays;

/**
 * Clase que representa un Centro de Control en un sistema de gestión de tráfico inteligente.
 * 
 * <p>Esta clase modela la información básica de un centro de control, incluyendo su 
 * identificador único, dirección, teléfono de contacto, datos de tráfico gestionados, 
 * y los semáforos inteligentes asociados. Es útil en sistemas basados en JavaFX para 
 * mostrar o gestionar esta información en interfaces gráficas.</p>
 */
public class CentroDeControl {

    /**
     * Identificador único del centro de control.
     */
    private String idCentroDeControl;

    /**
     * Dirección física del centro de control.
     */
    private String direccion;

    /**
     * Teléfono de contacto del centro de control.
     */
    private int telefono;

    /**
     * Array que contiene los datos de tráfico gestionados por el centro de control.
     */
    private DatosTrafico[] datosTrafico;

    /**
     * Array de semáforos inteligentes gestionados por el centro de control.
     */
    private SemaforoInteligente[] semaforoInteligente;

    /**
     * Constructor que inicializa un centro de control con su identificador, dirección, 
     * teléfono, datos de tráfico y semáforos inteligentes.
     * 
     * <p>Este constructor se puede utilizar para crear instancias que representen centros 
     * de control en la aplicación. Los objetos creados podrían mostrarse en una tabla 
     * de JavaFX o gestionarse mediante un controlador.</p>
     * 
     * @param idCentroDeControl Identificador del centro de control.
     * @param direccion Dirección del centro de control.
     * @param telefono Teléfono de contacto.
     * @param datosTrafico Array de datos de tráfico.
     * @param semaforoInteligente Array de semáforos inteligentes.
     */
    public CentroDeControl(String idCentroDeControl, String direccion, int telefono, DatosTrafico[] datosTrafico,
                           SemaforoInteligente[] semaforoInteligente) {
        super();
        this.idCentroDeControl = idCentroDeControl;
        this.direccion = direccion;
        this.telefono = telefono;
        this.datosTrafico = datosTrafico;
        this.semaforoInteligente = semaforoInteligente;
    }

    /**
     * Obtiene el identificador del centro de control.
     * 
     * @return El identificador del centro de control.
     */
    public String getIdCentroDeControl() {
        return idCentroDeControl;
    }

    /**
     * Establece el identificador del centro de control.
     * 
     * @param idCentroDeControl El identificador del centro de control.
     */
    public void setIdCentroDeControl(String idCentroDeControl) {
        this.idCentroDeControl = idCentroDeControl;
    }

    /**
     * Obtiene la dirección del centro de control.
     * 
     * @return La dirección del centro de control.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del centro de control.
     * 
     * @param direccion La dirección del centro de control.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el teléfono del centro de control.
     * 
     * @return El teléfono del centro de control.
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del centro de control.
     * 
     * @param telefono El teléfono del centro de control.
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene los datos de tráfico gestionados por el centro de control.
     * 
     * @return El array de datos de tráfico.
     */
    public DatosTrafico[] getDatosTrafico() {
        return datosTrafico;
    }

    /**
     * Establece los datos de tráfico gestionados por el centro de control.
     * 
     * @param datosTrafico El array de datos de tráfico.
     */
    public void setDatosTrafico(DatosTrafico[] datosTrafico) {
        this.datosTrafico = datosTrafico;
    }

    /**
     * Obtiene los semáforos inteligentes gestionados por el centro de control.
     * 
     * @return El array de semáforos inteligentes.
     */
    public SemaforoInteligente[] getSemaforoInteligente() {
        return semaforoInteligente;
    }

    /**
     * Establece los semáforos inteligentes gestionados por el centro de control.
     * 
     * @param semaforoInteligente El array de semáforos inteligentes.
     */
    public void setSemaforoInteligente(SemaforoInteligente[] semaforoInteligente) {
        this.semaforoInteligente = semaforoInteligente;
    }

    /**
     * Representación en formato de cadena de texto del centro de control con sus
     * atributos principales.
     * 
     * @return Cadena de texto representando al centro de control.
     */
    @Override
    public String toString() {
        return "CentroDeControl [idCentroDeControl=" + idCentroDeControl + ", direccion=" + direccion + ", telefono="
                + telefono + ", datosTrafico=" + Arrays.toString(datosTrafico) + ", semaforoInteligente="
                + Arrays.toString(semaforoInteligente) + "]";
    }
}
