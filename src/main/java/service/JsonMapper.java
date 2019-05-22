package service;

import com.github.wnameless.json.flattener.JsonFlattener;
import utility.FileUtility;

import java.util.Map;
import java.util.stream.Collectors;

public class JsonMapper {

    public static void main(String[] args) {

        JsonMapper mapper = new JsonMapper();
        String jsonString = FileUtility.convertStreamToString("sample.json");
        Map result = mapper.jsonToMap("type", jsonString);
        System.out.println(result);
    }

    public Map jsonToMap(String key, String jsonString) {

        Map<String, Object> flattenJson = JsonFlattener.flattenAsMap(jsonString);
        return flattenJson.entrySet().stream().filter(d ->  d.getKey().equals(key)||  d.getKey().endsWith("." + key) ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}




