package com.hcl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class App {

	final static String DIRECTORY = "C:\\LockedMe.com files";

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		displayWelcomeScreen();
		System.out.println();
		System.out.println();
		displayMainMenu();
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
			System.out.println("Closing application.");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid selection. Please choose 1, 2, or 3");

		}
		displayMainMenu();
	}

	private static void inputFileOperationChoice() {
		System.out.println("Please select option 1, 2, 3, or 4:");
		String fileOption = scanner.nextLine();
		switch (fileOption) {
		case "1":
			addFile();
			break;
		case "2":
			deleteFile();
			
		case "3":
			break;
		case "4":
			displayMainMenu();
			break;
			default:
				System.out.println("Invalid slecetion. Please select 1, 2, 3 or 4");

		}
		displayFileOperations();
	}

	private static void deleteFile() {
		System.out.println("Please type the name of one of the following files that you would like to delete");
		displayFilesInAscendingOrder();
		System.out.println();
		String fileToBeDeleted = scanner.nextLine();
		Path deletePath = Paths.get(fileToBeDeleted);
		
		if (!Files.exists(deletePath)) {
			System.out.println("Sorry, the specified file does not exist");
			return;

		}

	}

	private static void addFile() throws InvalidPathException {
		System.out.println("Please provide a file path:");
		String filePath = scanner.nextLine();
		Path path = Paths.get(filePath);

		if (!Files.exists(path)) {
			System.out.println("Sorry, the specified file does not exist");
			return;
		}

		String newFilePath = DIRECTORY + "/" + path.getFileName();
		int inc = 0;
		while (Files.exists(Paths.get(newFilePath))) {
			inc++;
			newFilePath = DIRECTORY + "/" + inc + "_" + path.getFileName();
		}
		try {
			Files.copy(path, Paths.get(newFilePath));
		} catch (IOException e) {
			System.out.println("Unable to copy file to " + newFilePath);
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
		for (File file : files) {
			if (!file.isFile()) {
				continue;
			}
			sortedFiles.add(file.getName());
		}
		sortedFiles.forEach(System.out::println);
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");

	}

	private static void displayMainMenu() {
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
