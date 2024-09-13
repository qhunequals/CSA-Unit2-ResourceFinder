import java.io.*;

public class Measure{

  private double[][] densities;

  public Measure(){
    densities = new double[30][20];

/* this checks for existing data file, if not then set values for densities*/

    if(checkForData()){
      for(int r = 0; r < densities.length; r++){
        for(int c = 0; c < densities[r].length; c++){
          //double material = possible[(int)(Math.random()*possible.length)];

          double max = 3.0;
          double min = 0.0;
      
          double material = Math.random()*(max-min+1)+min; 

          densities[r][c] = material;
        }
      }

      writeToFile();  // create and write densities values to file
      readFromFile();  // reads from file into densities in column-major order
    }
    else{
      readFromFile();  // reads from file into densities in column-major order
    }
  }

  public double getMaterial(int r, int c){
		if((r >= 0 && r <= 29) && (c >= 0 && c <= 19)){
    	return densities[r][c];
		}
		else{
			System.out.println("WARNING! That is not inside the grid.");
		}
		return -1;
  }
  // not used
  private boolean checkBoundary(double material, int r, int c){
    if(material > 0.5 && material < 0.6){
      for(int j = r - 1; j < r + 2; j++){
        for(int k = c - 1; k < c + 2; k++){
          if(j >= 0 && k >= 0 && j < densities.length && k < densities[0].length){
            if(densities[j][k] >= 0.9 && densities[j][k] <= 1.2){
              return false;
            }
          }
        }
      }
    }
    return true;  
  }

  private void writeToFile(){
    try{
      
      FileWriter fw = new FileWriter("data.txt");
      BufferedWriter bw = new BufferedWriter(fw);
      for(int r = 0; r < densities.length; r++){
        for(int c = 0; c < densities[0].length; c++){
          String data = "" + densities[r][c];
          bw.write(data);
          bw.newLine();
        }
      }
          
      bw.close();
      fw.close();   
      
    }catch(IOException e1){}
  }

  private boolean checkForData(){
    String line = "";
    try{
      
      FileReader fr = new FileReader("data.txt");
      BufferedReader br = new BufferedReader(fr);
      
      line = br.readLine();      
         
      br.close();
      fr.close();   
      
    }catch(IOException e2){}

    return line == null || line.length() < 1;
  }

/* reads from data file and puts values in densities in column-major order */

  private void readFromFile(){
    try{
      
      FileReader fr = new FileReader("data.txt");
      BufferedReader br = new BufferedReader(fr);
      
      String line = br.readLine(); 
     
      int r = 0;
      int c = 0;
      while(line != null){
         
        densities[r][c] = Double.parseDouble(line);
      
        r++;
        
        if(r == densities.length){
          r = 0;
          c++;
        }
        
        line = br.readLine(); 
      }       
         
      br.close();
      fr.close();    
      
    }catch(IOException e2){}
  }
}