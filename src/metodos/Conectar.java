package metodos;

import java.sql.*;


public class Conectar {
    
    Connection miconexion;
    Statement stSentencias;
    ResultSet rsDatos;
    PreparedStatement psPrepararSentencias;
    
    public Conectar () throws ClassNotFoundException, SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*String url = ("jdbc:mysql://remotemysql.com/phpmyadmin/index.php/hrKHsotkQ2");
            miconexion = DriverManager.getConnection(url, "hrKHsotkQ2","jlU6OKrlOL");*/
            String url = ("jdbc:mysql://localhost/proyectofinal");
            miconexion = DriverManager.getConnection(url, "root","");
            /*String url = ("jdbc:mysql://databases.000webhost.com/phpmyadmin/index.php/id10535857_proyectofinal");
            miconexion = DriverManager.getConnection(url, "id10535857_melof10","BOCACAMPEON");*/
            stSentencias = miconexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }
        catch (ClassCastException ex){
            throw ex;
        }
        catch (SQLException ex){
            throw ex;
        }
    }
    
    public ResultSet consulta (String sql ) throws SQLException{
        try{ 
            rsDatos = stSentencias.executeQuery(sql);
        }
        catch (SQLException ex){
              throw ex;        
        }        
        return rsDatos;    
    }
    
    
}
