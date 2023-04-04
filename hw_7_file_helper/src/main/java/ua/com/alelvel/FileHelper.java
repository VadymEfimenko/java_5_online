package ua.com.alelvel;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FileHelper {

    public List<File> listFiles(String directory) {
        File dir = new File(directory);
        if (dir.isDirectory()) {
            return FileUtils.listFilesAndDirs(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE).stream().toList();
        } else {
            return null;
        }
    }

    public boolean createNewFileInDirectory(String directory, String fileName) {
        File file = new File(directory + "/" + fileName);
        try {
            return file.createNewFile();
        } catch (IOException e) {
            System.out.println("unknown error, try again");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean createNewDirectoryInDirectory(String distDirectory, String dirName) {
        File file = new File(distDirectory + "/" + dirName);
        return file.mkdirs();
    }

    public boolean deleteFileFromDirectory(String directory, String fileName) {
        File file = new File(directory + "/" + fileName);
        return file.delete();
    }

    public void deleteDirectoryFromDirectory(String distDirectory, String dir) {
        File file = new File(distDirectory + "/" + dir);
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            System.out.println("unknown error, try again");
            System.out.println(e.getMessage());
        }
    }

    public void moveFileToDirectory(String fileName, String destinationDirectory) {
        File file = new File(fileName);
        File directory = new File(destinationDirectory);
        try {
            FileUtils.moveFileToDirectory(file, directory, false);
        } catch (IOException e) {
            System.out.println("unknown error, try again");
            System.out.println(e.getMessage());
        }
    }

    public List<File> findFileInDirectory(String directory, String fileName) {
        File sourceDir = new File(directory);
        List<File> searchedFiles = FileUtils.listFiles(sourceDir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)
                .stream()
                .filter(file -> file.getName().equalsIgnoreCase(fileName))
                .toList();
        if (!searchedFiles.isEmpty()) {
            return searchedFiles;
        } else {
            System.out.println("file is not found");
            return null;
        }
    }

    public List<File> findDirectoryInDirectory(String sourceDirectory, String searchedDirectory) {
        File sourceDir = new File(sourceDirectory);
        List<File> searchedDirs = FileUtils.listFilesAndDirs(sourceDir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)
                .stream()
                .filter(File::isDirectory)
                .filter(file -> file.getName().equalsIgnoreCase(searchedDirectory))
                .toList();
        if (!searchedDirs.isEmpty()) {
            return searchedDirs;
        } else {
            System.out.println("directory is not found");
            return null;
        }
    }

    public List<File> findTextInFilesOfDirectory(String directory, String text) {
        File dir = new File(directory);
        List<File> files = FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE).stream().toList();

        return files.stream().filter(file -> {
            try {
                return FileUtils.readLines(file, StandardCharsets.UTF_8)
                        .stream()
                        .anyMatch(line -> line.contains(text.toLowerCase()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }
}
