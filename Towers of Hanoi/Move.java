/**
   Represent a move for a Towers of Hanoi disk-moving bot
 */
public class Move {
    
    // instance fields
    private String source
                 , target
                 ;

    /**
      Construct an instance
     */
    public Move( String source
               , String target
               ) {
        this.source = source;
        this.target = target;
    }


    /**
       @return a string representation of this instance
     */
    public String toString() {
        String result;
        result =   "Move the top disk from " + source
                 + " to " + target + "."
                 ;
        return result; 
    }
}
