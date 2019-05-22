//package service;
//
//import com.jayway.jsonpath.JsonPath;
//import org.codehaus.jackson.map.ObjectMapper;
//import utility.FileUtility;
//
//import java.io.IOException;
//import java.util.*;
//
//public class JsonMapper2 {
//
//    public static void main(String[] args) {
//        JsonMapper2 mapper = new JsonMapper2();
//        Map jsonMap = mapper.getJsonObject("sample5.json");
//        Map result = mapper.jsonToMap("type", "", jsonMap, new HashMap());
//        System.out.println(result);
//    }
//
//    public Map getJsonObject(String fileName) {
//        String jsonString = FileUtility.convertStreamToString(fileName);
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        try {
//            return objectMapper.readValue(jsonString, Map.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//
//    public Map jsonToMap(String key, String path, Object jsonMap, Map<String, String> result) {
//
//
//            String s  = FileUtility.convertStreamToString(path);
//        List<Map<String, Object>> expensive = JsonPath.parse(s);
//                .read("$['book'][?]", expensiveFilter);
//        predicateUsageAssertionHelper(expensive);
//}
//
//
