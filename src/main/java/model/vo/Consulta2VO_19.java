package model.vo;

public class Consulta2VO_19 {
    private Integer id_proyecto;
    private Integer area_max;
    public Consulta2VO_19(Integer id_proyecto, Integer area_max) {
        this.id_proyecto = id_proyecto;
        this.setArea_max(area_max);
    }
    public Integer getArea_max() {
        return area_max;
    }
    public void setArea_max(Integer area_max) {
        this.area_max = area_max;
    }
    public Integer getId_proyecto() {
        return id_proyecto;
    }
    public void setId_proyecto(Integer id_proyecto) {
        this.id_proyecto = id_proyecto;
    }   
}