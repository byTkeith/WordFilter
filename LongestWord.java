import java.util.*;
import java.util.regex.Pattern;
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
                
                System.out.println(positionCount+" "+newString);

            }
            int maxValue=Integer.MIN_VALUE;
            for(Map.Entry<Integer,Integer> entry:report.entrySet()){
                int value=entry.getValue();
            }


        }   
        
    }
}
