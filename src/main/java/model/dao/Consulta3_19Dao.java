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

public class Consulta3_19Dao {
    public ArrayList<Consulta3VO_19> consulta3DAO() throws SQLException {

        ArrayList<Consulta3VO_19> respuesta = new ArrayList<Consulta3VO_19>();
        Connection conexion = JDBCUtilities.getConnection();

        try{       

            String consulta =   "SELECT ID_Proyecto,r.nombre || ' ' ||r.primer_apellido AS nombreapellido FROM Proyecto p  INNER JOIN  Lider r on r.ID_Lider = p.ID_Lider WHERE Banco_Vinculado = 'Bancolombia';";
            
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while(rs.next()){
                Consulta3VO_19 entidad = new Consulta3VO_19(
                    rs.getInt("id_proyecto"),
                    rs.getString("nombreapellido")
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
