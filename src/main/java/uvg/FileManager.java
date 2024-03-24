package uvg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileManager {
    public String readTXTFile(String fileName) throws FileNotFoundException, IOException{


        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/"+fileName)));

        String line;
        String result = "";

        while (( line = reader.readLine()) != null){
            result = result + line;
        } 

        reader.close();
        return result;
        
    }

    public void writeTXTFile(ArrayList<String> arrayList, String fileName, boolean isTest) throws IOException{
        String s = System.getProperty("java.class.path");
        String[] arr = s.split("target");
        String filePath;
        if(isTest){
            filePath = arr[0] + "src\\test\\resources\\" + fileName;
        }else{
            filePath = arr[0] + "src\\main\\resources\\" + fileName;
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        for(String line : arrayList){
            writer.write(line.toString()+"\n");
        }

        writer.close();
    }
}
