package com.carvajal.daoo;

import java.util.Scanner;

import com.carvajal.dao.impl.listaDeseoImpl;
import com.carvajal.dao.impl.productoImpl;
import com.carvajal.dao.impl.registroimpl;



public class Menu {

	
	
	Scanner teclado= new Scanner(System.in);
	private productoImpl catalogo = new productoImpl();
	private listaDeseoImpl lista = new listaDeseoImpl();
	private registroimpl reg = new registroimpl();
	public Menu() {};
					

	public void  Menualumnos() {
		
		
			System.out.println("\n" +"Bienvenidos !!"+"\n"+"Por favor seleccione la actividad a ejecutar: "
					+  "\n" + "\n" +
					"1. Catalogo de productos"+ "\n" + 
					"2. Listar favoritos "+ "\n" +
					"3. Agregar productos a favoritos "+ "\n" + 
					"4. Modificar lista de favoritos"+ "\n" +
					"5. Eliminar de favoritos "+ "\n" + 
					"6. Ver registros de usuario"+ "\n");
			
			int n = teclado.nextInt();
			
			
				switch (n) {
				case 1: {
					
					catalogo.listAll();}break;
				
				
				case 2: {
					
					lista.listAll();}break;
				
					
				case 3: {
					
					
						
					
					int opc=1, x = 1;
					catalogo.listAll();
					do {
					
					x = lista.Validate(opc);
					
					
					}while(x != 1);
					}break;
				
				case 4: {
					
					int opc=2, x = 1;
					lista.listAll();
					do{
						
					x=lista.Validate(opc);
				    }while(x != 1);}break;
					
				
				case 5: {
					
					int opc=3, x = 1;
					lista.listAll();
					do{
					
					lista.Validate(opc);
				}while(x != 1);}break;
					
				
				case 6: {
					
					reg.listAllRegistros();}break;
					
					
		     	default:{};
				}
				
				
				if(n<1 || n>6) {
					System.out.println("Opcion invalida");
						
							}
				
				
		    } 
			
		
		}
	
		
	
			

