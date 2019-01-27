package exceptions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExceptionDemoUnchecked {
    public static void main(String[] args)
    {
        readInArrayFromFile();
    }

    //method to read in some numbers from a file named "file.txt" and print them to console
    private static void readInArrayFromFile() {
        List<Integer> list = new ArrayList<Integer>();
        File file = new File("file.txt");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                list.add(Integer.parseInt(text));
            }
        } catch (FileNotFoundException e)
        {
            //in the real world, you would want these blocks to take appropriate actions,
            //to continue execution of program
            //and not just print errors
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IOException occurred");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                //because unchecked exceptions MUST be caught, some programmers just add
                //the mandatory catch block and leave it blank but this is bad practice
            }
        }

        //print out the list
        System.out.println(list);
    }

}
