package model.vo;

public class Consulta1VO_19 {
    private Integer id_proyecto;
    private String fecha_inicio;
    private String constructora;
    private String serial;

    public Consulta1VO_19 (){}

    public Consulta1VO_19 (Integer id_proyecto,
    String fecha_inicio,
    String constructora,
    String serial){
        this.id_proyecto = id_proyecto;
        this.fecha_inicio = fecha_inicio;
        this.constructora = constructora;
        this.serial = serial;
    }

    public Integer getId_proyecto() {
        return id_proyecto;
    }
    public String getSerial() {
        return serial;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }
    public String getConstructora() {
        return constructora;
    }
    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }
    public String getFecha_inicio() {
        return fecha_inicio;
    }
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    public void setId_proyecto(Integer id_proyecto) {
        this.id_proyecto = id_proyecto;
    }
}
