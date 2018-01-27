import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by cilu on 2017/11/20.
 */
public class TestSort {

    public static void main(String args[]) throws IOException {
        List<String> list = new ArrayList<String>();
        list.add("H5");
        list.add("技术中心");
        list.add("云帆工作室");
        list.add("F1火王");
        list.add("Java");
        list.add("N1项目组");
        Object[] str =  list.toArray();
        Arrays.sort(str);
        for(int i = 0 ; i < str.length ;i++){
            System.out.println(str[i]);
        }

        String str2 = "{\"head\":{\"responseCode\":\"40003\",\"responseMsg\":\"req is null\"},\"body\":{}}";
        Map<String,Object> response = (Map<String, Object>) JSON.parse(str2);
        System.out.println(response);
        Map<String,Object> head = (Map<String, Object>) JSON.parse(response.get("head").toString());
        System.out.println(head);
        System.out.println(head.get("responseCode"));
        System.out.println("time" + System.currentTimeMillis());

        ObjectMapper objectMapper = new ObjectMapper();
        JingqiResponse res = objectMapper.readValue(str2,JingqiResponse.class);
        System.out.println(res);
        System.out.println(res.getHead().get("responseCode"));
        JSONObject jsonObject = JSONObject.parseObject(str2);
        JSONObject jsonObject2 = JSONObject.parseObject(jsonObject.get("head").toString());
        System.out.println(jsonObject2.get("responseCode"));

        System.out.println(Float.parseFloat("12")*100);

    }

}
