package uvg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.crypto.Data;

public class Extractor {

    /**
     * @param str
     * @return 
     * @description make a simple extraction pairs from the input string
     */
    public static ArrayList<SimpleExtractionPair> getSimpleExtraction(String str){
        String regex = "\\((\\+|-|\\*|\\/|%|setq|quote|\\'|atom|list|equal|=|<|>|defun) ?([^\\(\\)]*)\\)";
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher(str);
        ArrayList<SimpleExtractionPair> order = new ArrayList<SimpleExtractionPair>();
        int counter = 1;

        while(matcher.find()){
            SimpleExtraction keyWord = SimpleExtractionMap.getInstance().getKeyword(matcher.group(1));
            str = str.replace(matcher.group(1), "");
            String innestExtract = matcher.group(0).replace(matcher.group(1), "");
            SimpleExtractionPair dataPair = new SimpleExtractionPair(keyWord, innestExtract);
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

    /**
     * @param str
     * @return 
     * @description make a compound extraction in groups from the input string
     */
    public static ArrayList<String> getCompoundExtractionGroups(String str){
        String regex = "\\((?:cond|if) (.*)\\)";
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher(str);
        //ArrayList<CompoundExtractionPair> pair = null;
        ArrayList<String> groups = null;
    
        while(matcher.find()){
            groups = Chunker.getChunks(matcher.group(1));
        }
        return groups;
    }

    /**
     */
    public static CompoundExtraction getCompoundExtractionType(String str){
        String regex = "\\((cond|if) (?:.*)\\)";
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            return CompoundExtractionMap.getInstance().getKeyword(matcher.group(1));
        }

        return null;
    }

    /**
     * @param str
     * @return 
     * @description make a compound extraction pairs from the input groups
     */
    public static Map<String, String[]> getCompoundExtractionPairs(ArrayList<String> groupsArr){
        String regex = "\\( *(\\(?[^\\(\\)]*\\)?) (.*)\\)";
        Pattern pattern = Pattern.compile(regex);
        Map<String, String[]> pairs = new HashMap<String, String[]>();
        int count = -1;
        String key = "";
        String current = "";

        for(String group : groupsArr){
            Matcher matcher = pattern.matcher(group);
            while(matcher.find()){
                count++;
            }

            String[] consequents = new String[count];
            matcher.reset();
            count = -1;

            while(matcher.find() && count < consequents.length){
                if(count == -1){
                    key = matcher.group(1);
                    group = group.replace(current, "");
                    matcher.reset(group);
                    count++;
                }else{
                    current = matcher.group(1);
                    consequents[count] = current;
                    group = group.replace(current, "");
                    matcher.reset(group);
                    count++;
                }
            }
            pairs.put(key, consequents);
        }
        return pairs;

    }

    public CompoundExtractionPair getCompoundExtractionPair(String str){
        CompoundExtraction type = getCompoundExtractionType(str);
        ArrayList<String> groups = getCompoundExtractionGroups(str);
        Map<String, String[]> map = getCompoundExtractionPairs(groups);
        return new CompoundExtractionPair(type, map);
    }

    

}
