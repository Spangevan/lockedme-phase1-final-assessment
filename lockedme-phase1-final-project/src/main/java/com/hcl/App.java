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

		case "3":

		}
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
