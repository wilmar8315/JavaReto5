package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.*;

public class Consulta1_19Dao {
    public ArrayList<Consulta1VO_19> consulta1DAO() throws SQLException {

        ArrayList<Consulta1VO_19> respuesta = new ArrayList<Consulta1VO_19>();
        Connection conexion = JDBCUtilities.getConnection();

        try{       

            String consulta =   "SELECT id_proyecto,Fecha_Inicio,Constructora,serial FROM Proyecto WHERE id_proyecto < 15;";
            
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while(rs.next()){
                Consulta1VO_19 entidad = new Consulta1VO_19(
                    rs.getInt("id_proyecto"),
                    rs.getString("fecha_inicio"),
                    rs.getString("constructora"),
                    rs.getString("serial")
                );
                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(entidad);
            }

            rs.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando ranking de bancos según el área promedio de proyectos respaldados: "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la colección de vo's
        return respuesta;
        
    }  
}
