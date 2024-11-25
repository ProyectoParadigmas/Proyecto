package co.edu.poli.demo.controlador;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.demo.modelo.SemaforoInteligente;
import co.edu.poli.demo.modelo.SemaforoPeatonal;
import co.edu.poli.demo.modelo.SemaforoVehicular;
import co.edu.poli.demo.modelo.Sensor;
import co.edu.poli.demo.servicios.ImplementacionOperacion;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class FormularioControlador {

    @FXML
    private RadioButton rbVehicular;

    @FXML
    private ToggleGroup rbTipo;

    @FXML
    private RadioButton rbPeatonal;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtEstado;

    @FXML
    private TextField txtUbicacion;

    @FXML
    private TextField txtIdSensor;

    @FXML
    private ComboBox<String> cBoxTipo;

    @FXML
    private TextField txtTiempoVerde;

    @FXML
    private TextField txtTiempoRojo;

    @FXML
    private TextField txtNumCarri;

    @FXML
    private Button btnguar;

    @FXML
    private Button btnModif;

    @FXML
    private Button btnElim;

    @FXML
    private Button btnSeri;

    @FXML
    private Button btnDeseria;

    @FXML
    private Button btnSalir;

    @FXML
    private TableColumn<SemaforoInteligente, String> tbTipo;

    @FXML
    private TableColumn<SemaforoInteligente, String> tbId;

    @FXML
    private TableColumn<SemaforoInteligente, String> tbUbicacion;

    @FXML
    private TableColumn<SemaforoInteligente, String> tbEstado;

    @FXML
    private TableColumn<SemaforoInteligente, String> tbIdSensor;

    @FXML
    private TableColumn<SemaforoInteligente, String> tbTiipoSensor;

    @FXML
    private TableColumn<SemaforoInteligente, String> tbTiempoV;

    @FXML
    private TableColumn<SemaforoInteligente, String> tbTiempoR;

    @FXML
    private TableColumn<SemaforoInteligente, String> tbNumero;

    @FXML
    private TableView<SemaforoInteligente> TableV;

    ObservableList<SemaforoInteligente> x;
    ImplementacionOperacion op;

    @FXML
    public void initialize() {
        x = FXCollections.observableArrayList();
        op = new ImplementacionOperacion();

        ObservableList<String> list = FXCollections.observableArrayList("Sensor de distancia",
                "Sensor de movimiento", "Sensor de contacto", "Sensor de velocidad");
        cBoxTipo.setItems(list);
    }

    @FXML
    void pressDes(ActionEvent event) {
    	Alert a = new Alert(AlertType.WARNING);
		try {
			op.setSemaforoVehicular(op.deserializar("", "binaryfile.bin"));
			x.clear();

			for (SemaforoInteligente semaforoInteligente : op.read1()) {
				if (semaforoInteligente != null)
					x.add(semaforoInteligente);
			}

			loadTable();
		} catch (Exception e) {
			a.setContentText("Error al abrir el archivo:"+e.getMessage());
			a.show();
		}
    }

    @FXML
    void pressElim(ActionEvent event) {
    	Alert a = new Alert(AlertType.CONFIRMATION);
		try {
			SemaforoInteligente e = TableV.getSelectionModel().getSelectedItem();
			x.remove(e);
			a.setContentText("Delete: " + op.delete((String) e.getCodigo()));
			loadTable();
			clear();
		} catch (Exception e) {
			a.setContentText("Seleccionar un registro");
		}
		a.show();

	}

    @FXML
    void loadTable() {
    	tbTipo.setCellValueFactory(cell -> new SimpleStringProperty(
    		    cell.getValue() instanceof SemaforoVehicular ? "Vehicular" : 
    		    (cell.getValue() instanceof SemaforoPeatonal ? "Peatonal" : "Desconocido")));
        tbId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdSemaforo()));
        tbUbicacion.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getUbicacion()));
        tbEstado.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getEstado()));
        tbIdSensor.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getSensor().getIdSensor()));
        tbTiipoSensor.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getSensor().getTipoSensor()));

        // Mostrar tiempos de semáforo peatonal o número de carriles de semáforo vehicular
        tbTiempoV.setCellValueFactory(cell -> {
            if (cell.getValue() instanceof SemaforoPeatonal) {
                return new SimpleStringProperty(String.valueOf(((SemaforoPeatonal) cell.getValue()).getTiempoVerdePeaton()));
            } else {
                return new SimpleStringProperty("N/A");
            }
        });

        tbTiempoR.setCellValueFactory(cell -> {
            if (cell.getValue() instanceof SemaforoPeatonal) {
                return new SimpleStringProperty(String.valueOf(((SemaforoPeatonal) cell.getValue()).getTiempoRojoPeaton()));
            } else {
                return new SimpleStringProperty("N/A");
            }
        });

        tbNumero.setCellValueFactory(cell -> {
            if (cell.getValue() instanceof SemaforoVehicular) {
                return new SimpleStringProperty(String.valueOf(((SemaforoVehicular) cell.getValue()).getNumeroCarriles()));
            } else {
                return new SimpleStringProperty("N/A");
            }
        });

        TableV.setItems(x);
    }

	void clear() {
		rbVehicular.setSelected(true);
		txtId.setText("");
		txtEstado.setText("");
		txtIdSensor.setText("");
		cBoxTipo.setValue("");
		txtUbicacion.setText("");
		txtTiempoVerde.setText("");
		txtTiempoRojo.setText("");
		txtNumCarri.setText("");
		
		
	}
    

	@FXML
	void pressGuar(ActionEvent event) {
	    Alert a = new Alert(AlertType.CONFIRMATION);
	    try {
	        if (txtId.getText().isEmpty() || txtUbicacion.getText().isEmpty() ||
	            txtEstado.getText().isEmpty() || txtIdSensor.getText().isEmpty()) {
	            a.setAlertType(AlertType.WARNING);
	            a.setContentText("Por favor, complete todos los campos obligatorios.");
	            a.show();
	            return;
	        }
	        
	        String idSemaforo = txtId.getText();
	        String ubicacion = txtUbicacion.getText();
	        String estado = txtEstado.getText();
	        String idSensor = txtIdSensor.getText();
	        String tipoSensor = cBoxTipo.getValue() != null ? cBoxTipo.getValue() : "N/A";
 
	        Sensor sensor = new Sensor(idSensor, tipoSensor);
	        SemaforoInteligente semaforo;
 
	        if (rbPeatonal.isSelected()) {
	            if (txtTiempoVerde.getText().isEmpty() || txtTiempoRojo.getText().isEmpty()) {
	                a.setAlertType(AlertType.WARNING);
	                a.setContentText("Por favor, ingrese los tiempos de semáforo peatonal.");
	                a.show();
	                return;
	            }
 
	            double tiempoVerde = Double.parseDouble(txtTiempoVerde.getText());
	            double tiempoRojo = Double.parseDouble(txtTiempoRojo.getText());
 
	            semaforo = new SemaforoPeatonal(idSemaforo, ubicacion, estado, sensor, tiempoVerde, tiempoRojo);
	        } else if (rbVehicular.isSelected()) {
	            if (txtNumCarri.getText().isEmpty()) {
	                a.setAlertType(AlertType.WARNING);
	                a.setContentText("Por favor, ingrese el número de carriles.");
	                a.show();
	                return;
	            }
 
	            int numeroCarriles = Integer.parseInt(txtNumCarri.getText());
	            semaforo = new SemaforoVehicular(idSemaforo, ubicacion, estado, sensor, numeroCarriles);
	        } else {
	            throw new Exception("Debe seleccionar un tipo de semáforo.");
	        }
 
	        x.add(semaforo); // Agregar el semáforo al ObservableList
	        loadTable(); // Actualizar la tabla
 
	        a.setContentText("Semáforo guardado exitosamente!");
	        clear(); // Limpiar los campos
	    } catch (Exception e) {
	        a.setAlertType(AlertType.ERROR);
	        a.setContentText("Error al guardar el semáforo: " + e.getMessage());
	    }
	    a.show();
	}

	@FXML
	void pressMod(ActionEvent event) {
	    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	    try {
	        // Verificar si se ha seleccionado un semáforo en la tabla
	        SemaforoInteligente semaforoSeleccionado = TableV.getSelectionModel().getSelectedItem();
	        if (semaforoSeleccionado == null) {
	            throw new Exception("Por favor, selecciona un semáforo de la tabla para modificar.");
	        }

	        // Obtener los valores actualizados desde los campos
	        String idSemaforo = txtId.getText();
	        String ubicacion = txtUbicacion.getText();
	        String estado = txtEstado.getText();
	        String idSensor = txtIdSensor.getText();
	        String tipoSensor = cBoxTipo.getValue() != null ? cBoxTipo.getValue() : "N/A";

	        // Crear un nuevo sensor con los datos actualizados
	        Sensor sensorActualizado = new Sensor(idSensor, tipoSensor);
	        SemaforoInteligente semaforoActualizado;

	        if (rbPeatonal.isSelected()) {
	            // Modificar como semáforo peatonal
	            double tiempoVerde = Double.parseDouble(txtTiempoVerde.getText());
	            double tiempoRojo = Double.parseDouble(txtTiempoRojo.getText());

	            if (!(semaforoSeleccionado instanceof SemaforoPeatonal)) {
	                throw new Exception("El semáforo seleccionado no es de tipo peatonal.");
	            }

	            // Crear un nuevo objeto actualizado
	            semaforoActualizado = new SemaforoPeatonal(idSemaforo, ubicacion, estado, sensorActualizado, tiempoVerde, tiempoRojo);

	        } else if (rbVehicular.isSelected()) {
	            // Modificar como semáforo vehicular
	            int numeroCarriles = Integer.parseInt(txtNumCarri.getText());

	            if (!(semaforoSeleccionado instanceof SemaforoVehicular)) {
	                throw new Exception("El semáforo seleccionado no es de tipo vehicular.");
	            }

	            // Crear un nuevo objeto actualizado
	            semaforoActualizado = new SemaforoVehicular(idSemaforo, ubicacion, estado, sensorActualizado, numeroCarriles);

	        } else {
	            throw new Exception("Debe seleccionar un tipo de semáforo.");
	        }

	        // Reemplazar el semáforo seleccionado en la lista
	        x.set(x.indexOf(semaforoSeleccionado), semaforoActualizado);

	        // Actualizar el servicio con los cambios
	        op.update(tipoSensor, semaforoActualizado);

	        // Recargar la tabla con los datos actualizados
	        loadTable();
	        alert.setContentText("Semáforo modificado exitosamente.");
	    } catch (Exception e) {
	        alert.setAlertType(Alert.AlertType.ERROR);
	        alert.setContentText("Error al modificar el semáforo: " + e.getMessage());
	    }

	    alert.show();
	    clear(); // Limpiar los campos del formulario
	}


    @FXML
    void pressSeria(ActionEvent event) {
    	Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText(op.serializar(op.read1(), "", "binaryfile.bin"));
		a.show();
		
    }

    @FXML
    void pressTable(MouseEvent event) {
        try {
            SemaforoInteligente semaforoin = TableV.getSelectionModel().getSelectedItem();

            if (semaforoin == null) {
                throw new Exception("Por favor, selecciona un semáforo de la tabla.");
            }

            txtId.setText(String.valueOf(semaforoin.getIdSemaforo()));
            txtEstado.setText(semaforoin.getEstado());
            txtUbicacion.setText(semaforoin.getUbicacion());
            txtIdSensor.setText(semaforoin.getSensor().getIdSensor());
            cBoxTipo.setValue(semaforoin.getSensor().getTipoSensor());

            // Asegúrate de manejar los tipos peatonales y vehiculares adecuadamente
            if (semaforoin instanceof SemaforoPeatonal) {
                rbPeatonal.setSelected(true);
                txtTiempoVerde.setText(String.valueOf(((SemaforoPeatonal) semaforoin).getTiempoVerdePeaton()));
                txtTiempoRojo.setText(String.valueOf(((SemaforoPeatonal) semaforoin).getTiempoRojoPeaton()));
            } else if (semaforoin instanceof SemaforoVehicular) {
                rbVehicular.setSelected(true);
                txtNumCarri.setText(String.valueOf(((SemaforoVehicular) semaforoin).getNumeroCarriles()));
            }
        } catch (Exception e) {
            Alert a = new Alert(AlertType.WARNING);
            a.setContentText("Selecciona un registro de la tabla.");
            a.show();
        }
    }}

    // Método para cargar los semáforos en la tabla


