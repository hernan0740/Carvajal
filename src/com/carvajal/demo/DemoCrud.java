package com.carvajal.demo;

import java.util.Scanner;

import com.carvajal.daoo.Menu;



public class DemoCrud {

	public static void main(String[] args) {
		

	
	Menu menu=new Menu();
	boolean primeravez=true;	
	int seguir = 0;
	Scanner teclado= new Scanner(System.in);
	
	
	while (seguir!=1) 
		
	{	
		try {
							
	if (primeravez == true)
    {
        
		menu.Menualumnos();
		
		primeravez = false;
		
    } 
    
	System.out.println("\n" +"Seleccionar: "+ "\n" +"\n" +"1.Menu principal"+"\n" +"2.Terminar");
	
		int reset = teclado.nextInt();
	
    if (reset == 1) {
        
        primeravez = true;
        }	
    if (reset==2){
    	seguir=1;
    	
    	System.out.println("\n" +"_________GRACIAS POR UTILIZAR NUESTRO SERVICIO_______");
    	}	
   
	
		} catch(Exception e) {
			
			System.out.println("Error de digitacion");
			
			System.out.println("\n" +"Seleccionar: "+ "\n" +"\n" +"1.Menu principal"+"\n" +"2.Terminar");
		
			int reset = teclado.nextInt();
		
	    if (reset == 1) {
	        
	        primeravez = true;
	        }	
	    if (reset==2){
	    	seguir=1;
	    	
	    	System.out.println("\n" +"_________GRACIAS POR UTILIZAR NUESTRO SERVICIO_______");
	    	}	
		}
   }
	
	}}
	
	

