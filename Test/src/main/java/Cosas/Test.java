package Cosas;

import bean.Proveedor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        String proveedores = "a";

        peticion(proveedores);
    }

    public static void peticion(String proveedores) throws SQLException, ClassNotFoundException, IOException {
        Proveedor p;
        List<Proveedor> listProv;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost:3306/pruebaibm","root", "1234");

        Statement s = conexion.createStatement();
        ResultSet rs = s.executeQuery ("select id_proveedor, nombre, fecha_de_alta, id_cliente " +
                "from pruebaibm.proveedores");

        listProv = new ArrayList<Proveedor>();
        while (rs.next())
        {
            p = new Proveedor(rs.getInt (1) , rs.getString (2), rs.getDate(3), rs.getString (4));
            listProv.add(p);
        }
        conexion.close();

        conversion(listProv);

    }
    private static void conversion(List<Proveedor> prov) throws IOException {
        String ruta = "C:\\Users\\usuario\\Desktop\\archivo1.txt";
        File f = new File(ruta);
        FileWriter fw = new FileWriter(f);
        BufferedWriter escritura = new BufferedWriter(fw);
        for(int i=0;i<prov.size();i++){
            escritura.write(prov.get(i).getId()+ ", " +prov.get(i).getNombre()+ ", "+prov.get(i).getFecha().toString()+ ", " +prov.get(i).getIdCliente().toString()+ ";" );
            escritura.newLine();

        }
        escritura.close();
    }
}
