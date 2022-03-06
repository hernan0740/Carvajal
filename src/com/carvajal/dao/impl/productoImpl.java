package com.carvajal.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.carvajal.database.Conexion;



public class productoImpl {

	public void listAll() {
		ResultSet r;
        //Realizamos la consulta sql para mostrar todos los datos de la tabla productos

		try {
			
		
			r = buscar("SELECT id,nombre,precio,cantidad FROM productos ");
			 System.out.println("\n A CONTINUACION SE MUESTRAN TODOS LOS PRODUCTOS DISPONIBLES:\n"+
			"_____________________________________________\n"+
			"ID| DESCRIPCION         | PRECIO  | CANTIDAD  ");
			
			while (r.next()) {
             
                System.out.println(r.getInt("id") + " | " +
                                   r.getString("nombre") + " | " +
                		           r.getString("precio") + "  |   " +
                		           r.getString("cantidad") 
                				   );
            				  }


	}catch (SQLException e) {
		
	
		e.printStackTrace();
		System.out.println(e.getMessage());
		System.out.println("No se pudo realizar la consulta " );
		
		
		
		}
		
	}

	ResultSet buscar(String sql) {
		
		Conexion conex = new Conexion();
		try {
		Statement estatuto = conex.getConnection().createStatement();
        
           
            return estatuto.executeQuery(sql);
        } catch (SQLException e) {
    		e.printStackTrace();
    		System.out.println(e.getMessage());
    		JOptionPane.showMessageDialog(null, "no se registro a " );
        }
        return null;

    }	
	

}
