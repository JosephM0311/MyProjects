import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Silver {
    public static void main(String[] args) {
        try {
            // Create scan of the file "ctravel.in"
            File file = new File("files/ctravel.in");
            Scanner input = new Scanner(file);

            // Test code for reading the file
              // while (input.hasNextLine()) {
              //   String line = input.nextLine();
              //   System.out.println(line);
              // }
            
            // Initialize variables for rows, columns, and time
            int row = input.nextInt();
            int column = input.nextInt();
            int time = input.nextInt();

            // Create two 2D arrays to store the previous and next steps
            String[][] prevArray = new String[row][column];
            String[][] nextArray = new String[row][column];
            
            // Convert "*" and "." to -1 and 0
            for (int rowIndex = 0; rowIndex < row; rowIndex++) {
                String line = input.next();
                for (int columnIndex = 0; columnIndex < column; columnIndex++) {
                    if(line.charAt(columnIndex) == '*') {
                      prevArray[rowIndex][columnIndex] = "-1";
                    } else {
                      prevArray[rowIndex][columnIndex] = "0";
                    }
                }
            }

            // Initialize variables for start and end points
            int startRow = input.nextInt();
            int startColumn = input.nextInt();
            int endRow = input.nextInt();
            int endColumn = input.nextInt();

            // Test code for printing out the variables
            // System.out.println("Start Row: " + startRow);
            // System.out.println("Start Column: " + startColumn);
            // System.out.println("End Row: " + endRow);
            // System.out.println("End Column: " + endColumn);

            // Set the start point to 1
            prevArray[startRow - 1][startColumn - 1] = "1";

            // Take steps for the given time, with each step converting the previous array to the next array
            for (int step = 0; step < time; step++) {
                takeStep(prevArray, nextArray);
                prevArray = nextArray;
                nextArray = new String[row][column];
            }

            // Test code to print out elements in prevArray
            // for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            //   for (int columnIndex = 0; columnIndex < column; columnIndex++) {
            //       System.out.print(prevArray[rowIndex][columnIndex] + " ");
            //   }
            //   System.out.println();
            // }

            // Print out the number of paths to the end point
            System.out.println(prevArray[endRow - 1][endColumn - 1]);

            // Releases the file from your program
            input.close(); 

        } catch (FileNotFoundException ex) {
            //File not found
            System.out.println("File not found D:");
          }
      }

    // Helper method that takes the sum of all adjacent squares and stores it in the next array
    public static void takeStep(String[][] beforeArray, String[][] afterArray) {
      for (int rowIndex = 0; rowIndex < beforeArray.length; rowIndex++) {
        for (int columnIndex = 0; columnIndex < beforeArray[0].length; columnIndex++) {
          if (beforeArray[rowIndex][columnIndex] != "-1") {
            int sum = 0;
            if (rowIndex > 0 && beforeArray[rowIndex - 1][columnIndex] != "-1") {
              sum += Integer.parseInt(beforeArray[rowIndex - 1][columnIndex]);
            }
            if (rowIndex < beforeArray.length - 1 && beforeArray[rowIndex + 1][columnIndex] != "-1") {
              sum += Integer.parseInt(beforeArray[rowIndex + 1][columnIndex]);
            }
            if (columnIndex > 0 && beforeArray[rowIndex][columnIndex - 1] != "-1") {
              sum += Integer.parseInt(beforeArray[rowIndex][columnIndex - 1]);
            }
            if (columnIndex < beforeArray[0].length - 1 && beforeArray[rowIndex][columnIndex + 1] != "-1") {
              sum += Integer.parseInt(beforeArray[rowIndex][columnIndex + 1]);
            }
            afterArray[rowIndex][columnIndex] = Integer.toString(sum);
          }
          else {
            afterArray[rowIndex][columnIndex] = "-1";
          }
        }
      }
    }

}
