package com.carvajal.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.carvajal.daoo.Producto;
import com.carvajal.database.Conexion;



public class listaDeseoImpl {
	
	Scanner teclado= new Scanner(System.in);
	//Se agrega productos a la lista de deseos
	public void save(int id, int cantidad) {

		Conexion conex = new Conexion();
		
		
		try {
			// El objeto estatuto mantiene la sesion y me sirve para procesar sentencial SQL y obtener lo
			// resultados de la misma
			Statement estatuto = conex.getConnection().createStatement();
			
			estatuto.execute("INSERT INTO listadeseo (idproducto,cantidad) VALUES ('"
					+ id + "','" + cantidad + "')");
			System.out.println("Se ha registrado exitosamente a lista de deseos ");

			estatuto.close();
				
			
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println( "no se registro a lista de deseos " );
		} 
		
		}
	
	
	//Se modifica cantidades solicitadas
	public void update(int id,int cantidad) {
		

	Conexion conex = new Conexion();

		try {
			
			Statement estatuto = conex.getConnection().createStatement();
			
			ResultSet r;
			r = search("SELECT idproducto,cantidad FROM listadeseo ");
			int add=0;
			while (r.next()) {
				
				if(r.getInt("idproducto")==id) {
					
					 add=cantidad+r.getInt("cantidad");
					estatuto.execute("UPDATE listadeseo SET "
							+ "cantidad='"+add+
							"' where idproducto='"+id+"' ");
				}
				
				
			}
			
			
			
			

			System.out.println( "Se ha modificado exitosamente " );

			estatuto.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println( "no se ha modificado exitosamente a " );
		} 
	
		
	}


	//Lista todos los productos de la lista de favoritos
	public void listAll() {
			
			ResultSet r;
			ResultSet r2;
	        //Realizamos la consulta sql para mostrar todos los datos de la lista de deseos

			try {
				
				r2 = search("SELECT idproducto,cantidad FROM listadeseo ");			
				String acumulado="";	
					 System.out.println("\n SE MUESTRAN TODOS LOS REGISTROS DE LA LISTA DE DESEOS:\n"+
							 "____________________________________\n"+
							 "ITEM| DESCRIPCION       |ID-PRODUCTO|PRECIO|CANTIDAD " );
				
					 int cont=1;
				while (r2.next()) {
					
					r = search("SELECT id,nombre,precio,cantidad FROM productos ");
					
					while (r.next() ) {
					
		             if(r2.getInt("idproducto")==r.getInt("id")) {
		            	 
		            	if(r.getInt("cantidad")<r2.getInt("cantidad")) {
		            	 
		            	 delete(r2.getInt("idproducto"));
		            	 
		            	 System.out.println("El producto "+r.getString("nombre")+"se elimino de favoritos- sin stock");
		            	 
		            	 }
		            	 
		            	 
		            	 
		            	 acumulado=" "+cont+ " | "+
		            			   
		                           r.getString("nombre") + " |    " +
		                           r2.getInt("idproducto") + "    | " +
		            			   r.getString("precio")+ " |   " +
		            			   r2.getString("cantidad")+ "  | " +
		                           "\n"+acumulado;
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
	
    //Se elimina item de la lista de deseos	
	public void delete(int id) {
		
		Conexion conex = new Conexion();

		try {
			
			Statement estatuto = conex.getConnection().createStatement();
			
			estatuto.execute("DELETE FROM listadeseo where idproducto='"+id+"' ");
			System.out.println("Se ha eliminado exitosamente ");

			//estatuto.execute("ALTER TABLE  listadeseo AUTO_INCREMENT='"+1+"' ");
			
			estatuto.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println( "no se ha eliminado " );
		} 
		
		
		
	}

	public int Validate(int opc) {
		
		boolean error=true;
		int cantidad=0;
		ResultSet r;
		
		
		if(opc==1) {
		int agregado=0;
		System.out.println("Digite id de producto a agregar:");
		int id = teclado.nextInt();
		
		if( id > 0 ) {
	
			//if(opc==1) {
	
			r = search("SELECT id,cantidad FROM productos ");
		 
		try {
					
				while (r.next()) {
			
				  if(r.getInt("id")==id && r.getInt("cantidad")>0) {
				
					
				
					   do {
							System.out.println( "Digite cantidad de producto a agregar:" );
							cantidad = teclado.nextInt();
									
							  if(r.getInt("cantidad")>=cantidad) {
									
										save(id,cantidad);
										//error=true;
										//break;
										agregado++;	
							  }else {error=true; System.out.println( "Cantidad supera stock" );}
										
							}while(cantidad >=r.getInt("cantidad"));
							     
					   error=true;
						
				}else {error=false;}
			
			}
			
		if(error==false && agregado>0) {
				System.out.println( "Id incorrecta o producto sin stock" );
				return 0;}

				error=true;
				agregado=0;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		}}
		
		
		if(opc==2) {
			int agregado=0;
			System.out.println("Digite id de producto a modificar:");
			int id = teclado.nextInt();
			r = search("SELECT idproducto,cantidad FROM listadeseo ");
			 
			try {
				while (r.next()) {
				
				if(r.getInt("idproducto")==id) {
					
					System.out.println( "Digite cantidad de producto a agregar:" );
					cantidad = teclado.nextInt();
					
					if(r.getInt("cantidad")>=cantidad) {
					
						update(id,cantidad);
						agregado++;
					}else {error=true;System.out.println( "Cantidad supera stock" );}
					
				}else {error=false;}}
		
		if(error==false && agregado>0 ) {System.out.println( "Id incorrecta" );return 0;}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		
		
		if(opc==3) {
			
			int agregado=0;
			System.out.println("Digite id de producto a eliminar:");
			 int id = teclado.nextInt();
			r = search("SELECT idproducto,cantidad FROM listadeseo ");
			 
			try {
				while (r.next()) {
				
				if(r.getInt("idproducto")==id) {
					
					delete(id);					
					agregado++;
					
				}else {error=false;}
				
								}
				
				if(error==false && agregado<0) {System.out.println( "Id incorrecta" );
				return 0;}
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		
		
		
		return 1;
	}
	
	

}
