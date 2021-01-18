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

	public static void main(String[] args) throws InvalidPathException, IOException {
		
		Path rootDirectory = Paths.get(DIRECTORY);
		if (!Files.exists(rootDirectory)) {
			Files.createDirectory(rootDirectory);
			
		}
		
		displayWelcomeScreen();
		System.out.println();
		System.out.println();
		displayMainMenu();
	}

	private static void inputMainMenuChoice() throws InvalidPathException, IOException {
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
		System.out.println("Please select option 1, 2 or 3:");
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
		String option = scanner.nextLine();
		switch (option) {
		case "1":
			displayFilesInAscendingOrder();
			break;

		case "2":
			displayFileOperations();

		case "3":
			displayCloseScreen();
			break;
		default:
			System.out.println("Invalid selection. Please choose 1, 2, or 3");
			System.out.println();

		}
		displayMainMenu();
	}

	private static void inputFileOperationChoice() throws InvalidPathException, IOException {
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
		System.out.println("Please select option 1, 2, 3, or 4:");
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
		String fileOption = scanner.nextLine();
		switch (fileOption) {
		case "1":
			addFile();
			break;
		case "2":
			deleteFile();
			break;
		case "3":
			searchforFile();
			break;
		case "4":
			displayMainMenu();
			break;
		default:
			System.out.println("Invalid slecetion. Please select 1, 2, 3 or 4");
			System.out.println();

		}
		displayFileOperations();
	}

	private static void searchforFile() {
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
		System.out.println("Please type the path of a file to search for:");
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
		String fileSearch = scanner.nextLine();
		Path searchPath = Paths.get(fileSearch);

		if (!Files.exists(searchPath)) {
			System.out.println("We are sorry, the file you have searched for does not exist.");
			System.out.println();
			return;
		} else {
			System.out.println("The file you have searched for exists!!");	
			System.out.println();
		}

	}

	private static void deleteFile() throws IOException {
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
		System.out.println("Please type the path of one of the following files that you would like to delete");
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
		displayFilesInAscendingOrder();
		System.out.println();
		String fileToBeDeleted = scanner.nextLine();
		Path deletePath = Paths.get(fileToBeDeleted);

		if (!Files.exists(deletePath)) {
			System.out.println("Sorry, the specified file does not exist");
			return;

		} else {
			Files.delete(deletePath);
			System.out.println();
			System.out.println("Thank you! You have successfully deleted the file");
			System.out.println("Returing you to the previous menu.");
			System.out.println();

		}

	}

	private static void addFile() throws InvalidPathException, IOException {
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
		System.out.println("Please provide a file path:");
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
		String filePath = scanner.nextLine();
		Path path = Paths.get(filePath);

		if (!Files.exists(path)) {
			Files.createFile(path);
			System.out.println("You have succesfully created a file, and it has been added to the target directory.");
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

	private static void displayFileOperations() throws InvalidPathException, IOException {
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
		System.out.println("1.) Add a file to the directory");
		System.out.println("2.) Delete a file from the directory");
		System.out.println("3.) Search for a file in the directory");
		System.out.println("4.) Return to main menu");
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
		inputFileOperationChoice();
	}

	private static void displayFilesInAscendingOrder() {
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
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
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
		System.out.println();

	}

	private static void displayMainMenu() throws InvalidPathException, IOException {
		System.out.println("~+~+~+~+- MAIN MENU -~+~+~+~+~+");
		System.out.println();
		System.out.println("1.) Display all files in ascending order");
		System.out.println("2.) File Operations Menu");
		System.out.println("3.) Quit the application");
		System.out.println();
		System.out.println("~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~");
		inputMainMenuChoice();

	}
	
	private static void displayCloseScreen() {
		
		System.out.println("~||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||~");
		System.out.println("+||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||+");
		System.out.println("~|| ==============                                             \\  //                      ||~");
		System.out.println("+||       ||        ||                          || //           \\//                       ||+");
		System.out.println("~||       ||        ||=====     ===     ||===   ||//            ||     ====    ||    ||   ||~");
		System.out.println("+||       ||        ||    ||   || ||\\   ||   |  ||\\             ||    ||  ||   ||    ||   ||+");
		System.out.println("~||       ||        ||    ||    ===  \\  ||   |  || \\            ||    ||  ||   ||    ||   ||~");
		System.out.println("+||                                                                    ====      ====     ||+");
		System.out.println("~||                                                                                       ||~");
		System.out.println("+||                                                                                       ||+");
		System.out.println("~||                                                                                       ||~");
		System.out.println("+||Thank you for using the LockedMe.com file application.                                 ||+");
		System.out.println("~||                                                                                       ||~");
		System.out.println("+||Closing the application. Goodbye!                                                      ||+");
		System.out.println("~||                                                                                       ||~");
		System.out.println("+||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||+");
		System.out.println("~||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||~");
		System.exit(0);
		
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
		System.out.println("~||In order to interact with the application, please type the corresponding       ||~");
		System.out.println("~||number in the command line, followed by the enter key to select an option!     ||~");
		System.out.println("+||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||+");
		System.out.println("~||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||~");

	}
}
