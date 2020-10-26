package pinger;

//https://www.geeksforgeeks.org/pinging-ip-address-java-set-2by-creating-sub-process/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
  
public class Pinger 
{  
    static void commands(ArrayList<String> commandList)  
                                           throws Exception 
    {  
        ProcessBuilder build = new ProcessBuilder(commandList); 
        Process process = build.start(); 
          
        BufferedReader input = new BufferedReader(new InputStreamReader 
                                   (process.getInputStream())); 
        BufferedReader Error = new BufferedReader(new InputStreamReader 
                                   (process.getErrorStream())); 
        String s = null; 
          
        System.out.println("Standard output: "); 
        while((s = input.readLine()) != null) 
        { 
            System.out.println(s); 
        } 
        System.out.println("error (if any): "); 
        while((s = Error.readLine()) != null) 
        { 
            System.out.println(s); 
        } 
    } 
      
    public static void main(String args[]) throws Exception 
    {  
        if (args.length != 1) {
            System.out.println("Enter one IP or a web address as an argument");
            System.exit(0);
        } 

        ArrayList<String> commandList = new ArrayList<String>(); 
          
        commandList.add("ping"); 
        commandList.add(args[0]); 
          
        Pinger.commands(commandList); 
    } 
} 