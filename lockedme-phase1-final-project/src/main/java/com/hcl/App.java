package com.hcl;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	
	final static String DIRECTORY = "/";
	
	static Scanner scanner = new Scanner(System.in);
	
	
    public static void main( String[] args )
    {
        displayWelcomeScreen();
    	System.out.println();
    	System.out.println();
        displayMainMenue();
    }
    
    
    
    
    
    private static void displayMainMenue() {
    	System.out.println("~+~+~+~+- MAIN MENU -~+~+~+~+");
    	System.out.println();
        System.out.println("1.) Display all files in ascending order");
        System.out.println("2.) File Operations Menu");
        System.out.println("3.) Quit the application");
    	System.out.println();
        System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
    	
    }
    
    
    private static void displayWelcomeScreen() {
    	System.out.println("~||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||~");
    	System.out.println("+||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||+");
    	System.out.println("~|| \\             //   _____             ____     ____                   ____     ||~");
    	System.out.println("+||  \\    //\\    //  ||        ||       |        |    |    //\\    //\\   |         ||+");
    	System.out.println("~||   \\  //  \\  //   ||=====   ||       |        |    |   //  \\  //  \\  |====     ||~");
    	System.out.println("+||    \\//    \\//    ||_____   ||____   |____    |____|  //    \\//    \\ |____     ||+");
    	System.out.println("~||                                                                               ||~");
    	System.out.println("+||                                                                               ||+");
    	System.out.println("~||                                                                               ||~");
    	System.out.println("+||                                                                               ||+");
    	System.out.println("~||                                                                               ||~");
    	System.out.println("+||Application: LockedMe.com Phase 1 Final Assessment                             ||+");
    	System.out.println("~||                                                                               ||~");
    	System.out.println("+||Developer: Evan Spangenberg                                                    ||+");
    	System.out.println("~||                                                                               ||~");
    	System.out.println("+||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||+");
    	System.out.println("~||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||~");



    }
}
