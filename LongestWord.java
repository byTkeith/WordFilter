import java.util.*;
import java.util.regex.Pattern;

import javax.swing.RowFilter.Entry;

import java.io.*;
import java.util.regex.Matcher;
public class LongestWord {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> filteredWords= new LinkedHashMap<>();
        LinkedHashMap<Integer,Integer> report=new LinkedHashMap<>();
        ArrayList<String> unFliteredWords=new ArrayList<>();
        File inputFile = new File("words.txt");
        try{Scanner scanner=new Scanner(inputFile);
            while(scanner.hasNextLine()){
                unFliteredWords.add(scanner.nextLine());
            }
            
        }catch(FileNotFoundException e){
            System.out.println("File not Found askies!!");
        }
        int positionCount=0;
        int longest=0;
        int maxValue=Integer.MIN_VALUE;
        int reportPosition=0;
        //String newString="";

        for(String euLine:unFliteredWords){
            Pattern pattern= Pattern.compile("\\p{Punct}");
            Matcher matcher =pattern.matcher(euLine);
            if(matcher.find()){
                positionCount++;
                String newString=euLine.replaceAll("\\p{Punct}", "");
                filteredWords.put(positionCount,newString);
                char[] splitString=newString.toCharArray();
                int lengthOfNewString=splitString.length;
                report.put(positionCount, lengthOfNewString);
                //System.out.println(positionCount+" "+newString);
                try {
                    FileWriter fileWriter = new FileWriter("words2.txt");
                    PrintWriter printWriter = new PrintWriter(fileWriter);
        
                    for(Map.Entry<Integer, String> entry: filteredWords.entrySet()){
                        printWriter.println(entry.getKey()+" "+entry.getValue());
                        //printWriter.println("The longest word is at position " + reportPosition);

                    }
                    printWriter.println("The longest word in this text file is "+"["+reportPosition+"]"+"\n"+filteredWords.get(reportPosition)+" with "+maxValue+" letters.");
                   
                    
                    printWriter.close();
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error during reading/writing. Oops!");
                }
            }
            for(Map.Entry<Integer,Integer> entry:report.entrySet()){
                int value=entry.getValue();
                if(value>maxValue){
                    maxValue=value;
                    if(entry.getValue()==maxValue){
                        reportPosition=entry.getKey();
                    } 
                }
            }
           
        }
        //System.out.println("The longest word in this text file is "+"["+reportPosition+"]"+"\n"+filteredWords.get(reportPosition)+" with "+maxValue+" letters.");
       
       
       
        
    }

}
