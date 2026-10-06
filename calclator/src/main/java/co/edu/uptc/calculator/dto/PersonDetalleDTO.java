package co.edu.uptc.calculator.dto;

public class PersonDetalleDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String container;
    private String mensaje;

    public PersonDetalleDTO(Long id, String nombre, String apellido,
            String container, String mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.container = container;
        this.mensaje = mensaje;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getContainer() {
        return container;
    }

    public String getMensaje() {
        return mensaje;
    }
}