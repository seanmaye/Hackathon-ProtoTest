package ProtoTest;

import java.io.*;
import static java.lang.System.*;
import java.util.ArrayList;
public class ReadClassObject extends IOException{
	private FileReader fr;
    private BufferedReader br;
    private String str;
    private ArrayList<String> lines;	
    public ReadClassObject(String filename) throws FileNotFoundException{
    	lines = new ArrayList<String>();
    	fr = new FileReader(filename);
    	br = new BufferedReader(fr);
        try{
        
	        do {
	        	str = br.readLine();
	        	if(str != null)
	        		lines.add(str);
	        }while(str !=  null);
	        br.close();
	
	        } catch (IOException e) {
	            System.out.println("File Not Found");
	        }
    }
    
    public ArrayList<String> getInfo(){
    	return lines;
    }
   
}

