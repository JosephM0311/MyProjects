/**
 * Joseph Mei
 * hw052
 * worked with no one
 * advised by no one
 * 
   Exercise the ToH class
 */
public class UserOfToH {
    /**
       Command line arguments are optional, but if used,
       they must appear in this order:
       0. number of disks
       1. source spike name
       2. target spike name
       3. name of spare spike

       For example,
          java UserOfToH 3 Hanoi HCMC "Da Nang"
     */
    public static void main( String[] commandLine) {

        // If the user specified no command-line arguments...
        if( commandLine.length == 0) {
            // ... standard tests of recursion, in standard order:
           System.out.println(
               System.lineSeparator()
             + "Moves, for various problems"
             + System.lineSeparator()
             // +
             );

            // base case only
            ToH baseCaseOnly = new ToH( 0, "Atlantis", "Avalon", "Shangri-La");
            oneTest( "just the base case"
                   , baseCaseOnly
                   );
    
            // the smallest recursive case
            ToH smallestRecursiveCase =
              new ToH( 1, "Kingman", "Barstow", "Berdoo ");
            oneTest( "smallest recursive case"
                   , smallestRecursiveCase
                   );
    
    
            // The classic 3 cities with 3 disks provides
            // a larger recursive case,
            ToH classic = new ToH( 3, "Kingman", "Barstow", "Berdoo ");
            oneTest( "classic 3 cities with 3 disks"
                   , classic
                   );
        }  // end of standard tests

        // Accepting problems from the command line makes it easy
        // to play with the program.
        else{
            ToH commanded = new ToH( Integer.parseInt( commandLine[0])
                                   , commandLine[1]
                                   , commandLine[2]
                                   , commandLine[3]
                                   );
            oneTest( "command-line request"
                   , commanded
                   );
        }
    }


    /**
       run one test
     */
    private static void oneTest( String description
                               , ToH toh
                               ) {
        System.out.println( description);
        toh.generateMoves();
        System.out.println( toh
                          + System.lineSeparator());
     }

}