package uvg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.crypto.Data;

public class Extractor {

    public static ArrayList<DataTriplet> extract(String str){
        String regex = "\\((\\+|-|\\*|\\/|%|setq|quote|\\'|atom|list|equal|<|>|cond|defun) ?([^\\(\\)]*)\\)";
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher(str);
        ArrayList<DataTriplet> order = new ArrayList<DataTriplet>();
        int counter = 1;

        while(matcher.find()){
            EEvaluationType keyWord = ReservedKeyWords.getInstance().getKeyword(matcher.group(1));
            EExtractionType extractionType = ExtractionKeyWords.getInstance().getEvaluationType(matcher.group(1));
            str = str.replace(matcher.group(1), "");
            String innestExtract = matcher.group(0).replace(matcher.group(1), "");
            DataTriplet dataPair = new DataTriplet(extractionType, keyWord, innestExtract);
            order.add(dataPair);
            if(str.contains(innestExtract)){
                str = str.replace(innestExtract, "REPLACE"+counter);
                matcher.reset(str);
                counter++;
            }else{
                break;
            }
          }

          return order;


    }
}
