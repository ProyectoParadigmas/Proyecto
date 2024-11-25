/**
 * Módulo principal de la aplicación JavaFX.
 *
 * Este módulo configura las dependencias necesarias para ejecutar la aplicación y define 
 * la visibilidad de los paquetes internos.
 *
 * @author [Jonathan Castillo y Sonia Valero]
 * @version 1.0
 * @since [24/11/2024]
 */
module ProyectoFnial {
    /**
     * Requiere el módulo JavaFX Controls para utilizar elementos de la interfaz de usuario.
     */
    requires javafx.controls;

    /**
     * Requiere el módulo JavaFX Graphics para trabajar con gráficos y escenas.
     */
    requires javafx.graphics;

    /**
     * Requiere el módulo JavaFX FXML para cargar interfaces de usuario definidas en archivos FXML.
     */
    requires javafx.fxml;

    /**
     * Requiere el módulo JavaFX Base, que contiene clases fundamentales para la plataforma JavaFX.
     */
    requires javafx.base;

    /**
     * Permite el acceso al paquete de controladores para que JavaFX pueda instanciar clases en tiempo de ejecución.
     *
     * @see javafx.fxml.FXMLLoader
     */
    opens co.edu.poli.demo.controlador to javafx.fxml;

    /**
     * Permite el acceso al paquete de vistas para que JavaFX pueda cargar archivos FXML.
     *
     * @see javafx.fxml.FXMLLoader
     */
    opens co.edu.poli.demo.vista to javafx.fxml;

    /**
     * Exporta el paquete de vistas para que sea accesible desde otros módulos.
     */
    exports co.edu.poli.demo.vista;
}