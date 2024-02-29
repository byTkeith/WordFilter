import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
import java.util.regex.Matcher;
public class LongestWord {
    public static void main(String[] args) {
        ArrayList<String> filteredWords= new ArrayList<>();
        ArrayList<String> unFliteredWords=new ArrayList<>();
        File inputFile = new File("words.txt");
        try{Scanner scanner=new Scanner(inputFile);
            while(scanner.hasNextLine()){
                unFliteredWords.add(scanner.nextLine());
            }
            
        }catch(FileNotFoundException e){
            System.out.println("File not Found askies!!");
        }
        for(String euLine:unFliteredWords){
            Pattern pattern= Pattern.compile("[!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~]");
            Matcher matcher =pattern.matcher(euLine);
            if(matcher.find()){
                String newString=euLine.replaceAll("\\p{Punct}", "");

            }

        }   
        
    }
}
