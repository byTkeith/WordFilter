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
            int reportPosition=0;
            for(Map.Entry<Integer,Integer> entry:report.entrySet()){
                int value=entry.getValue();
                if(value>maxValue){
                    maxValue=value;
                    if(entry.getValue()==maxValue){
                        reportPosition=entry.getKey();
                    } 
                }
            }
            //int reportPosition=report.
            File outputFile=new File("words2.txt");
            try(Scanner userinput=new Scanner(System.in);
                FileWriter writer = new FileWriter(outputFile);
            ){
                System.out.println("The following has been printed");
                while (userinput.hasNextLine()) {
                    String line =userinput.nextLine();
                    if(line.equals("Done")){
                        break;
                    }
                    writer.write(line+"\n");
                }System.out.println("The longest word in this text file is "+"["+reportPosition+"]"+"\n"+report.get(reportPosition)+" with "+maxValue+" letters.");
            }catch(IOException e){
                e.printStackTrace();
            


        }   
        
    }
}
