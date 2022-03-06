package com.carvajal.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.carvajal.daoo.Producto;
import com.carvajal.database.Conexion;

public class registroimpl {
	
	
	
	
	//Se agrega registro de productos 
		public void save(Producto id) {

			Conexion conex = new Conexion();

			try {
				// El objeto estatuto mantiene la sesion y me sirve para procesar sentencial SQL y obtener lo
				// resultados de la misma
				Statement estatuto = conex.getConnection().createStatement();
				
				estatuto.execute("INSERT INTO regproducto (idproducto) VALUES ('"
						+ id +"')");
				

				estatuto.close();

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				
			} 
			
			}
		
	//Lista todos los registros de los  productos de la lista de deseos
		public void listAllRegistros() {
				
				ResultSet r;
				ResultSet r2;
		        //Realizamos la consulta sql para mostrar todos los datos de la lista de deseos

				try {
					
					r2 = search("SELECT id,idproducto,cantidad FROM listadeseo ");			
					String acumulado="";	
						 System.out.println("\n Se lista el registro de todos los productos agregados por clientes:\n"+
								 "_____________________________________\n"+
								 "ITEM| DESCRIPCION        |ID-PRODUCTO|  ");
						int cont=1;
						while (r2.next()) {
						r = search("SELECT id,nombre,precio FROM productos ");
						
						while (r.next() ) {
												
			             if(r2.getInt("idproducto")==r.getInt("id")) {
			            	 
			            	 acumulado=" "+cont+ "  | "+
			                           r.getString("nombre") + " |   " +
			                           r.getInt("id") + "   | " +
			            			   //r.getString("precio")+ " | " +
			            			   //r2.getString("cantidad")+ " | " +
			                           acumulado+"\n";
			            	 cont++;	                
			            }
						}
						if(acumulado!="") {
							
							System.out.println(acumulado);
							
						}
						
					acumulado="";				
					}
				

			}catch (SQLException e) {
				
			
				e.printStackTrace();
				System.out.println(e.getMessage());
				JOptionPane.showMessageDialog(null, "no se registro a " );
				
				
				
				}
				}
		
		ResultSet search(String sql) {
			
			Conexion conex = new Conexion();
			try {
			Statement estatuto = conex.getConnection().createStatement();
	        
	           
	        return estatuto.executeQuery(sql);
	        
	        } catch (SQLException e) {
	    		e.printStackTrace();
	    		System.out.println(e.getMessage());
	    		System.out.println( "No se pudo realizar la busqueda  " );
	        }
	        return null;

	    }	
			
}
