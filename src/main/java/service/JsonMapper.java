package service;

import org.codehaus.jackson.map.ObjectMapper;
import utility.FileUtility;
import java.io.IOException;
import java.util.*;

public class JsonMapper {

    public static void main(String[] args) {

        JsonMapper mapper = new JsonMapper();
        Map jsonMap = mapper.getJsonObject("sample5.json");
        Map result = mapper.jsonToMap("type", "", jsonMap, new HashMap());
        System.out.println(result);
    }

    public Map getJsonObject(String fileName) {
        String jsonString = FileUtility.convertStreamToString(fileName);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(jsonString, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Map jsonToMap(String key, String path, Object jsonMap, Map<String, String> result) {

        for (Map.Entry<String, Object> e : ((LinkedHashMap<String, Object>) jsonMap).entrySet()) {
            StringBuilder sb = new StringBuilder().append(path).append(e.getKey());

            if (e.getValue() instanceof ArrayList) {
                List<LinkedHashMap> list = (List<LinkedHashMap>) e.getValue();

                for (int i = 0; i < list.size(); i++) {
                    sb = new StringBuilder(sb.toString().replaceAll("\\[(\\d)\\]\\.", ""));
                    if (list.get(i) instanceof LinkedHashMap) {
                        jsonToMap(key, sb.append("[").append(i).append("]").append(".").toString(), list.get(i), result);
                    } else if (e.getKey().equals(key)){
                        result.put(sb.toString(), String.valueOf(e.getValue()));}
                }
            } else {
                if (!(e.getValue() instanceof LinkedHashMap)) {
                    if (e.getKey().equals(key)){
                        result.put(sb.toString(), String.valueOf(e.getValue()));}
                } else
                    jsonToMap(key, sb.append(".").toString(), e.getValue(), result);
            }
        }
        return result;
    }
}




