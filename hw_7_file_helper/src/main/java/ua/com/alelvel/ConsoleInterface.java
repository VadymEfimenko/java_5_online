package ua.com.alelvel;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleInterface {
    FileHelper fileHelper = new FileHelper();

    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the FileHelper");
        System.out.println("Select options:");
        String select;
        menu();
        while ((select = bf.readLine()) != null) {
            try {
                crud(bf, select);
            } catch (RuntimeException e) {
                System.out.println("something goes wrong");
                System.out.println(e.getMessage());
            }
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("List files and directories in your directory ->  1");
        System.out.println("Create new file in directory -> 2");
        System.out.println("Create new directory in directory -> 3");
        System.out.println("Delete file from directory -> 4");
        System.out.println("Delete directory from directory -> 5");
        System.out.println("Move file to directory -> 6");
        System.out.println("Find file in directory -> 7");
        System.out.println("Find directory in directory -> 8");
        System.out.println("Find text in files of directory -> 9");
        System.out.println("If you want close, please enter 0");
    }

    private void crud(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> listFiles(reader);
            case "2" -> createNewFileInDirectory(reader);
            case "3" -> createNewDirectoryInDirectory(reader);
            case "4" -> deleteFileFromDirectory(reader);
            case "5" -> deleteDirectoryFromDirectory(reader);
            case "6" -> moveFileToDirectory(reader);
            case "7" -> findFileInDirectory(reader);
            case "8" -> findDirectoryInDirectory(reader);
            case "9" -> findTextInFilesOfDirectory(reader);
            case "0" -> System.exit(0);
        }
        menu();
    }

    private void listFiles(BufferedReader reader) throws IOException {
        System.out.println("enter your directory");
        String directory = reader.readLine();
        List<File> allFiles = fileHelper.listFiles(directory);
        List<File> files = allFiles.stream().filter(File::isFile).toList();
        List<File> dirs = allFiles.stream().filter(File::isDirectory).toList();
        System.out.println("\n Files: \n");
        files.forEach(System.out::println);
        System.out.println("\n Dirs: \n");
        dirs.forEach(System.out::println);
    }

    public void createNewFileInDirectory(BufferedReader reader) throws IOException {
        System.out.println("enter your directory");
        String directory = reader.readLine();
        System.out.println("enter file name");
        String fileName = reader.readLine();
        System.out.println(fileHelper.createNewFileInDirectory(directory, fileName));
    }

    public void createNewDirectoryInDirectory(BufferedReader reader) throws IOException {
        System.out.println("enter your directory where you want to create new directory");
        String directory = reader.readLine();
        System.out.println("enter name of new directory");
        String directoryName = reader.readLine();
        System.out.println(fileHelper.createNewDirectoryInDirectory(directory, directoryName));
    }

    public void deleteFileFromDirectory(BufferedReader reader) throws IOException {
        System.out.println("enter directory name");
        String directory = reader.readLine();
        System.out.println("enter file name");
        String fileName = reader.readLine();
        System.out.println(fileHelper.deleteFileFromDirectory(directory, fileName));
    }

    public void deleteDirectoryFromDirectory(BufferedReader reader) throws IOException {
        System.out.println("enter root directory name");
        String directory = reader.readLine();
        System.out.println("enter directory name you want to delete");
        String dirToDelete = reader.readLine();
        fileHelper.deleteDirectoryFromDirectory(directory, dirToDelete);
    }

    public void moveFileToDirectory(BufferedReader reader) throws IOException {
        System.out.println("enter filename name");
        String fileName = reader.readLine();
        System.out.println("enter directory name you want move file");
        String distDir = reader.readLine();
        fileHelper.moveFileToDirectory(fileName, distDir);
    }

    public void findFileInDirectory(BufferedReader reader) throws IOException {
        System.out.println("enter directory name");
        String directory = reader.readLine();
        System.out.println("enter file name");
        String fileName = reader.readLine();
        fileHelper.findFileInDirectory(directory, fileName).forEach(System.out::println);
    }

    public void findDirectoryInDirectory(BufferedReader reader) throws IOException {
        System.out.println("enter directory name where you want search");
        String sourceDirectory = reader.readLine();
        System.out.println("enter directory name that you searching for");
        String searchedDirectory = reader.readLine();
        fileHelper.findDirectoryInDirectory(sourceDirectory, searchedDirectory).forEach(System.out::println);
    }

    public void findTextInFilesOfDirectory(BufferedReader reader) throws IOException {
        System.out.println("enter directory name where you want search");
        String directory = reader.readLine();
        System.out.println("enter text that you searching for");
        String text = reader.readLine();
        fileHelper.findTextInFilesOfDirectory(directory, text).forEach(System.out::println);
    }
}
