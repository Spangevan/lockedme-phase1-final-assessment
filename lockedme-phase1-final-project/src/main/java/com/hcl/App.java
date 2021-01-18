package com.hcl;

import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Hello world!
 *
 */
public class App {

	final static String DIRECTORY = "C:\\LockedMe.com files";

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		displayWelcomeScreen();
		System.out.println();
		System.out.println();
		displayMainMenue();
	}

	private static void inputMainMenuChoice() {
		System.out.println("Please select option 1, 2 or 3:");
		String option = scanner.nextLine();
		switch (option) {
		case "1":
			displayFilesInAscendingOrder();
			break;
		case "2":
			displayFileOperations();

		case "3":
			 System.out.println("Thanks for using lockedme.com. Closing application.");
             System.exit(0);
             break;

		}
	}
	
	private static void inputFileOperationChoice() {
		System.out.println("Please select option 1, 2, 3, or 4:");
		String fileOption = scanner.nextLine();
		switch(fileOption) {
		case "1":
			
		case "2":
			
		case "3":
			
		case "4":
			displayMainMenue();

		}
	}
	
	
	
	private static void displayFileOperations() {
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
        System.out.println("1.) Add a file to the directory");
        System.out.println("2.) Delete a file from the directory");
        System.out.println("3.) Search for a file in the directory");
        System.out.println("4.) Return to main menu");
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
		inputFileOperationChoice();
    }
	
	
	private static void displayFilesInAscendingOrder() {
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
		System.out.println("All files organized in ascending order:");
		File[] files = new File(DIRECTORY).listFiles();
		Set<String> sortedFiles = new TreeSet<>();
		for(File file: files) {
			if (!file.isFile()) {
				continue;
			}
			sortedFiles.add(file.getName());
		}
		sortedFiles.forEach(System.out::println);
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");



	}

	private static void displayMainMenue() {
		System.out.println("~+~+~+~+- MAIN MENU -~+~+~+~+");
		System.out.println();
		System.out.println("1.) Display all files in ascending order");
		System.out.println("2.) File Operations Menu");
		System.out.println("3.) Quit the application");
		System.out.println();
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
		inputMainMenuChoice();

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
