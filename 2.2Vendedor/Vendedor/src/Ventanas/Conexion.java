
package Ventanas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;
    
    static String bd="XE";
    static String login="VINATERIA2";
    static String password="vinateria2";
    static String url="jdbc:oracle:thin:@localhost:1521:XE";
    
    public static Connection Enlace(Connection conn)throws SQLException    {
        try {
         Class.forName("oracle.jdbc.OracleDriver");
         conn=DriverManager.getConnection(url, login, password);
        }
        catch(ClassNotFoundException e )
        {
            System.out.print("Clase no encontrada");
        }
        return conn;
    }
    
    public static Statement sta(Statement st)throws SQLException    {
        conn=Enlace(conn);
        st=conn.createStatement();
        return st;
    }
    
    public static ResultSet tablaPersonal(ResultSet rs)throws SQLException    {
       st=sta(st);
       rs=st.executeQuery("SELECT ID_PERSONAL,\n" +
                            "NOMBRE, PATERNO,\n" +
                            "MATERNO,\n" +
                            "DIRECCION,\n" +
                            "TELEFONO,\n" +
                            "CORREO,\n" +
                            "SEXO.SEXO,\n" +
                            "ID_JORNADA_LABORAL,\n" +
                            "SUCURSAL, \n" +
                            "STATUS.STATUS \n" +
                        "FROM PERSONAL \n" +
                        "INNER JOIN SEXO ON PERSONAL.ID_SEXO = SEXO.ID_SEXO\n" +
                        "INNER JOIN STATUS ON PERSONAL.ID_STATUS = STATUS.ID_STATUS \n "+ 
                        "ORDER BY ID_PERSONAL ASC");
       return rs;
    }
    
    public static ResultSet tablaClientes(ResultSet rs)throws SQLException    {
       st=sta(st);
       rs=st.executeQuery("SELECT * FROM CLIENTE ORDER BY ID_CLIENTE ASC");
       return rs;
    }
    
    public static ResultSet tablaProveedores(ResultSet rs)throws SQLException    {
       st=sta(st);
       rs=st.executeQuery("SELECT ID_PROVEEDOR,\n"
               + "NOMBRE,\n"
               + "DIRECCION,\n"
               + "TELEFONO,\n"
               + "CORREO,\n"
               + "RFC,\n"
               + "CONTACTO,\n"
               + "STATUS.STATUS \n"
               + "FROM PROVEEDOR  \n"
               + "INNER JOIN STATUS ON PROVEEDOR.ID_STATUS = STATUS.ID_STATUS \n "
               + "ORDER BY ID_PROVEEDOR ASC");
       return rs;
    }
    
    public static ResultSet tablaProductos(ResultSet rs)throws SQLException    {
       st=sta(st);
       rs=st.executeQuery("SELECT * FROM PRODUCTO ORDER BY ID_PRODUCTO ASC");
       return rs;
    }
    
    public static ResultSet ticket(ResultSet rs)throws SQLException    {
        st=sta(st);
        rs=st.executeQuery("SELECT NOMBREPRODUCTO.NOMBREPRODUCTO,\n" +
"       DETALLE_VENTA.CANTIDAD,\n" +
"       DETALLE_VENTA.PRECIO_UNITARIO,\n" +
"       DETALLE_VENTA.PRECIO_TOTAL\n" +
"       FROM DETALLE_VENTA, PRODUCTO \n"+
"       INNER JOIN NOMBREPRODUCTO ON PRODUCTO.ID_NOMBREPRODUCTO = NOMBREPRODUCTO.ID_NOMBREPRODUCTO");
        return rs;
    }
    
        public static ResultSet compra(ResultSet rs)throws SQLException    {
        st=sta(st);
        rs=st.executeQuery("SELECT NOMBREPRODUCTO.NOMBREPRODUCTO,\n" +
"        DETALLE_COMPRA.CANTIDAD,\n" +
"        DETALLE_COMPRA.PRECIO_UNITARIO,\n" +
"        DETALLE_COMPRA.PRECIO_TOTAL\n" +
"       FROM DETALLE_COMPRA, PRODUCTO \n" +
"       INNER JOIN NOMBREPRODUCTO ON PRODUCTO.ID_NOMBREPRODUCTO = NOMBREPRODUCTO.ID_NOMBREPRODUCTO");
        return rs;
    }
        
    public static ResultSet tablaUsuarios(ResultSet rs)throws SQLException    {
        st=sta(st);
        rs=st.executeQuery("SELECT ID_PERSONAL,\n" +
                 "USUARIO,\n" +
                 "PASSWORD,\n" +
                 "STATUS.STATUS \n" +
                 "FROM USUARIOS\n" +
                 "INNER JOIN STATUS ON USUARIOS.ID_STATUS = STATUS.ID_STATUS \n "+ 
                 "ORDER BY ID_PERSONAL ASC");
        return rs;
    }

    public static ResultSet tablaVentas(ResultSet rs)throws SQLException    {
        st=sta(st);
        rs=st.executeQuery("SELECT VENTA.ID_VENTA,\n" +
"       VENTA.FECHA,\n" +
"       VENTA.TOTAL,\n" +
"       PERSONAL.NOMBRE,\n" +
"       VENTA.ID_CLIENTE, \n" +
        "STATUS.STATUS \n" +
"FROM VENTA\n" +
"INNER JOIN PERSONAL ON VENTA.ID_PERSONAL = PERSONAL.ID_PERSONAL\n" +
"INNER JOIN STATUS ON VENTA.ID_STATUS = STATUS.ID_STATUS \n" +
"ORDER BY ID_VENTA");
        return rs;
    }


    public static ResultSet tablaCompras(ResultSet rs)throws SQLException    {
        st=sta(st);
        rs=st.executeQuery("SELECT ID_COMPRA,\n" +
        "FECHA,\n" +
        "TOTAL, \n" +
        "PROVEEDOR.NOMBRE, \n" +
        "STATUS.STATUS \n" +
        "FROM COMPRA\n" +
        "INNER JOIN PROVEEDOR ON COMPRA.ID_PROVEEDOR = PROVEEDOR.ID_PROVEEDOR\n" +
        "INNER JOIN STATUS ON COMPRA.ID_STATUS = STATUS.ID_STATUS \n" 
      + "ORDER BY ID_COMPRA");
        return rs;
    }    
}
