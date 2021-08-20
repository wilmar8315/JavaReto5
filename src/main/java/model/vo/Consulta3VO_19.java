package model.vo;

public class Consulta3VO_19 {
    private Integer id_proyecto;
    public Consulta3VO_19(Integer id_proyecto, String nombreApellido) {
        this.setId_proyecto(id_proyecto);
        this.setNombreApellido(nombreApellido);
    }
    public String getNombreApellido() {
        return nombreApellido;
    }
    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }
    public Integer getId_proyecto() {
        return id_proyecto;
    }
    public void setId_proyecto(Integer id_proyecto) {
        this.id_proyecto = id_proyecto;
    }
    private String nombreApellido;
    
}
