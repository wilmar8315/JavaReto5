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

public class Consulta2_19Dao {
    public ArrayList<Consulta2VO_19> consulta2DAO() throws SQLException {

        ArrayList<Consulta2VO_19> respuesta = new ArrayList<Consulta2VO_19>();
        Connection conexion = JDBCUtilities.getConnection();

        try{       

            String consulta =   "SELECT id_proyecto,area_max FROM Proyecto p INNER JOIN Tipo pf on p.id_tipo = pf.id_tipo WHERE p.Numero_Habitaciones = 2;";
            
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while(rs.next()){
                Consulta2VO_19 entidad = new Consulta2VO_19(
                    rs.getInt("id_proyecto"),
                    rs.getInt("area_max")
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