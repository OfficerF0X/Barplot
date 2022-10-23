package ASCIIArt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AsciiArt {
    /**
     * It checks if a file is a rectangle
     *
     * @param filename the name of the file to check
     */
    public static void checkFile(String filename) {
        Scanner scanner = null;
        int last = 0;
        int count = 0;
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            return;
        }
        while(scanner.hasNextLine()) {
            count += 1;
            String line = scanner.nextLine();
            if(last == 0) {
                last = line.length();
            }
            else if(last != line.length()) {
                System.out.println(filename + ": Exception");
                return;
            }
        }
        scanner.close();
        System.out.println(filename + ": ok " + last + " " + count);
    }

    /**
     * It checks if the file exists and if it does, it prints out the content of the file
     */
    public static void main(String[] args) {
        String picture1 = "bild1.ascii";
        String picture2 = "bild2.ascii";
        String picture3 = "bild3.ascii";
        String src = "src\\ASCiiArt\\";
        checkFile(src + picture1);
        System.out.println("----------");
        checkFile(src +picture2);
        System.out.println("----------");
        checkFile(src + picture3);
        System.out.println("----------");
    }
}
