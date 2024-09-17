// Resource Finder Starter Code              A+CR
class Main {
    public static void main(String[] args) {
      Measure world = new Measure();
          
      for(int r = 0; r < 30; r++){
        for(int c = 0; c < 20; c++){
          // Write your code here.


          double mat = world.getMaterial(r, c);
          mat = mat * 100;
          int n = (int)(mat + 0.5);
          mat = (double)(n) / 100; // lines 11-14 rounds the density to the hundredths place;


          String rock = "";
          if (mat >= 0 && mat <= 0.55){
            rock = "Unpacked Snow";
          }
          else if (mat >= 0.83 && mat <= 0.97){
            rock = "Glacial Ice";
          }
          else if (mat >= 0.97 && mat <= 2.7){
             rock = "Sedimentary Rock";
          }
          else if (mat >= 2.71 && mat <= 3.2){
            rock = "Igneous Rock";
          }
          else if (mat >= 3.21){
            rock = "Metamorphic Rock";
          } 
          else{
            rock = "Nothing?";
          }  // lines 17-35 sets the rock to their type depending on what the density is


          if (rock == "Unpacked Snow"){
            System.out.println("WARNING: UNPACKED SNOW AT ROW " + r + " COLUMN " + c);
            System.out.println();
          } // lines 38-41 sets a warning wherever snow is
          

          System.out.println("Row " + r + " and Column " + c + " has a density of " + mat + ", which means it is " + rock);
          System.out.println(); // lines 44-45

         
          // This marks the end of your code segment.
        }
      } 
       /* this code allows the program to finish displaying all the values to the console
       you must press the STOP button to stop the program from running */
       while (true);    
    }
  }