//https://www.geeksforgeeks.org/pinging-ip-address-java-set-2by-creating-sub-process/
package pinger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
  
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
        String ip;
        try (Scanner scan = new Scanner(System.in)){
            System.out.println("Enter an IP or a web address.");
            ip = scan.nextLine();
        }
        // creating list for commands 
        ArrayList<String> commandList = new ArrayList<String>(); 
          
        commandList.add("ping"); 
        // can be replaced by IP 
        commandList.add(ip); 
          
        Pinger.commands(commandList); 
    } 
} 