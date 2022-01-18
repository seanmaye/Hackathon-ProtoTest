package ProtoTest;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteClassObject extends IOException{
	private String path;
	FileWriter fw;
	PrintWriter pw;
	public WriteClassObject(String p){
		path = p;
		main();
	}
	public static void main(String[]args){
		WriteClassObject wco = new WriteClassObject("ProtoTest/Accounts/Students/Noob.txt");
	}
    public void main(){
        try {
           fw = new FileWriter(path); //   "path/student.txt"
           pw = new PrintWriter(fw); 
       }
       catch (IOException e) {
           System.out.println("ERROR!");
       }
    }
    public void pLine(String line){
    	try{
    		pw.println(line);
    	}catch (Exception e) {
            System.out.println(e);
        }
    	
    }
    public void pClose(){
    	try{
    		pw.close();
    	}catch (Exception e) {
            System.out.println("ERROR!");
        }
    }
  
}

