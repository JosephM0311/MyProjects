import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bronze {
    public static void main(String[] args) {
        try {
            // Create scan of the file "makelake.in"
            File file = new File("files/makelake.in");
            Scanner input = new Scanner(file);

            // // Test code for reading the file
            //   while (input.hasNextLine()) {
            //     String line = input.nextLine();
            //     System.out.println(line);
            //   }
            
            // Initialize variables for rows, columns, elevation, and number of instructions
            int row = input.nextInt();
            int column = input.nextInt();
            int elevation = input.nextInt();
            int numOfInstructions = input.nextInt();
            
            // Create a 2D array to store the initial elevations in the pasture
            int[][] pasture = new int[row][column];
            
            // Populate pasture with the initial elevations from the scan
            for (int rowIndex = 0; rowIndex < row; rowIndex++) {
                for (int columnIndex = 0; columnIndex < column; columnIndex++)
                      pasture[rowIndex][columnIndex] = input.nextInt();
            }

            // // Test code for printing out the pasture
            // for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            //   for (int columnIndex = 0; columnIndex < column; columnIndex++) {
            //       System.out.print(pasture[rowIndex][columnIndex] + " ");
            //   }
            //   System.out.println();
            // }
            
            // Create a 2D array that stores the setOfInstructions to be run
            int[][] setOfInstructions = new int[numOfInstructions][3];
            for (int rowIndex = 0; rowIndex < numOfInstructions; rowIndex++) {
                for (int columnIndex = 0; columnIndex < 3; columnIndex++)
                      setOfInstructions[rowIndex][columnIndex] = input.nextInt();
            }

            // // Test code for printing out the setOfInstructions
            // for (int rowIndex = 0; rowIndex < numOfInstructions; rowIndex++) {
            //   for (int columnIndex = 0; columnIndex < 3; columnIndex++) {
            //       System.out.print(setOfInstructions[rowIndex][columnIndex] + " ");
            //   }
            //   System.out.println();
            // }
            
            // Follow the setOfInstructions to dig the lake
            for(int[] instruction: setOfInstructions) 
                dig(pasture, instruction);

            // // Test code for printing out the pasture
            // for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            //   for (int columnIndex = 0; columnIndex < column; columnIndex++) {
            //       System.out.print(pasture[rowIndex][columnIndex] + " ");
            //   }
            //   System.out.println();
            // }

            // Convert pasture into an array holding the depths of the lake that are below the desired elevation
            for (int rowIndex = 0; rowIndex < row; rowIndex++) {
                for (int columnIndex = 0; columnIndex < column; columnIndex++){
                    int difference = elevation - pasture[rowIndex][columnIndex];
                    if(difference > 0)
                        pasture[rowIndex][columnIndex] = difference;
                    else
                        pasture[rowIndex][columnIndex] = 0;
                }
            }

            // // Test code for printing out the pasture
            // for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            //     for (int columnIndex = 0; columnIndex < column; columnIndex++) {
            //         System.out.print(pasture[rowIndex][columnIndex] + " ");
            //     }
            //     System.out.println();
            //   }

            // Find the sum of the aggravated depths
            int aggravatedDepth = 0;
            for (int rowIndex = 0; rowIndex < row; rowIndex++) {
                for (int columnIndex = 0; columnIndex < column; columnIndex++){
                    aggravatedDepth += pasture[rowIndex][columnIndex];
                }
            }

            // Find the volume
            int volume = aggravatedDepth * 72 * 72;

            System.out.println(volume);


            input.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found D:");
            }
    }

    public static void dig(int[][] pasture, int[] instruction) {
        int startRow = instruction[0];
        int startColumn = instruction[1];
        int depth = instruction[2];
        
        int tallestElev = 0; // Stores the largest num in the 3x3 array

        // Find the largest number in the 3x3 array
        for(int row = startRow - 1; row < startRow + 2; row++) {
            for(int column = startColumn - 1; column < startColumn + 2; column++){
                if (pasture[row][column] > tallestElev)
                    tallestElev = pasture[row][column];
            }
        }

        int depthToReach = tallestElev - depth; // Stores the depth to be dug down to

        // Changes the elevations of the pasture array into the newly dug depths
        for(int row = startRow - 1; row < startRow + 2; row++) {
            for(int column = startColumn - 1; column < startColumn + 2; column++){
                if (pasture[row][column] > depthToReach)
                    pasture[row][column] = depthToReach;
            }
        }
    }
}
