package wet;
import java.io.*;
import java.util.*;

public class Birdmanedraw {
private Formatter y;
private Scanner x;

public void open(String s, String g)
{
	try {
		y= new Formatter(String.format("%s%s%s", "C:\\",s,".txt"));
		y.format("%s",g);
		
		
	}
	catch(Exception e){
		System.out.println("exists");
	}
	}
public void closeFile(){
	try {y.close();}
	catch(Exception e)
	{
	}
	}




public void openFile(String s){
	try {
		x= new Scanner(new File(String.format("%s%s%s", "C:\\",s,".txt")));
		String a=  x.nextLine();
		
	}
	catch(Exception e){
		System.out.println("no exist");
		
	}
}

}


