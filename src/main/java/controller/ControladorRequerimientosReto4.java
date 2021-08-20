package controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

//Modelos (acceso y objetos contenedores)
import model.dao.*;
import model.vo.*;

//Librerías para bases de datos
import java.sql.SQLException;

public class ControladorRequerimientosReto4 {       

    private final Consulta1_19Dao daoConsulta1;
    private final Consulta2_19Dao daoConsulta2;
    private final Consulta3_19Dao daoConsulta3;

    public ControladorRequerimientosReto4(){
        daoConsulta1 = new Consulta1_19Dao();
        daoConsulta2 = new Consulta2_19Dao();
        daoConsulta3 = new Consulta3_19Dao();
    }
    
    public ArrayList<Consulta1VO_19> realizarConsulta1() throws SQLException {
        return this.daoConsulta1.consulta1DAO();
    }

    public ArrayList<Consulta2VO_19> realizarConsulta2() throws SQLException {
        return this.daoConsulta2.consulta2DAO();
    }
    public ArrayList<Consulta3VO_19> realizarConsulta3() throws SQLException {
        return this.daoConsulta3.consulta3DAO();
    }   
}

