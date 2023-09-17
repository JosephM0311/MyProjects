/**
 * Joseph Mei
 * hw042
 * worked with no one
 * advised by no one
 * 
   Exercise the RaggedRoom class
 */
public class UserOfRaggedRoom {
    public static void main( String[] commandLine) {

        int[] fileLengths = new int[commandLine.length];

        for (int index = 0; index < commandLine.length; index++)
            fileLengths[index] = Integer.parseInt(commandLine[index]);

        RaggedRoom room307 = new RaggedRoom();

        RaggedRoom randomRoom = new RaggedRoom(fileLengths);

        System.out.println(
                System.lineSeparator()
              + "----- see room 307, with its ragged seating -----"
              + System.lineSeparator()
              + room307
              );
         /* Expecting, eventually, to see a filled-in version of...
               number of files: 5
               files
               0    ranks:  0 1 2 3 4 5 6 7
                    person: 0 1 2 ...     7

               1    ranks:  0 1 2 3 4 5
                    person: 8 9 ...   13

               2    ranks:  0 1 2 3 4 5
                    person: 14 ...    21

               3    ranks:  0 1 2 3 4 5 6
                    person:

               4    ranks:  0 1 2 3 4 5 6
                    person:     ...     33
         */


         // create and display a rectangular room
        System.out.println(
                System.lineSeparator()
              + "----- see a rectangular room -----"
              + System.lineSeparator()
              + new RaggedRoom(4, 3)
              );

        // create and display a random room with file 
        // lengths given by the commandLine
        System.out.println(
                System.lineSeparator()
              + "----- see a ragged room -----"
              + System.lineSeparator()
              + randomRoom
              );
        }
}
