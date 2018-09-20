package cn.zxy.zmanager.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("hiding")
public class FastJSONHelper { 

    /**
     * 将java类型的对象转换为JSON格式的字符串
     * @param object java类型的对象
     * @return JSON格式的字符串
     */
	public static <T> String serialize(T object) {
    	return JSON.toJSONString(object,SerializerFeature.WriteMapNullValue);
    }
    
    /**
     * 将java类型的对象转换为JSON格式的字符串， 可定制输出格式
     * @param object
     * @param serializerFeature
     * @return
     */
    public static <T> String serialize(T object, SerializerFeature serializerFeature) {
    	return JSON.toJSONString(object, serializerFeature);
    }


    /**
     * 将JSON格式的字符串转换为java类型的对象或者java数组类型的对象，不包括java集合类型
     * @param json JSON格式的字符串
     * @param clz java类型或者java数组类型，不包括java集合类型
     * @return java类型的对象或者java数组类型的对象，不包括java集合类型的对象
     */
    public static <T> T deserialize(String json, Class<T> clz) {
        return JSON.parseObject(json, clz);
    }

    /**
     * 将JSON格式的json Object 转换为java类型的对象或者java数组类型的对象，不包括java集合类型
     * @param jsonObj json Object
     * @param clz java类型或者java数组类型，不包括java集合类型
     * @return java类型的对象或者java数组类型的对象，不包括java集合类型的对象
     */
    public static <T> T deserialize(JSONObject jsonObj, Class<T> clz) {
        if(jsonObj == null){
            return null;
        }
        return JSON.parseObject(jsonObj.toJSONString(), clz);
    }

    /**
     * 将JSON格式的字符串转换为List<T>类型的对象
     * @param json JSON格式的字符串
     * @param clz 指定泛型集合里面的T类型
     * @return List<T>类型的对象
     */
    public static <T> List<T> deserializeList(String json, Class<T> clz) {
        return JSON.parseArray(json, clz);
    }

    /**
     * 将JSON Array转换为List<T>类型的对象
     * @param jsonArray JSON格式的字符串
     * @param clz 指定泛型集合里面的T类型
     * @return List<T>类型的对象
     */
    public static <T> List<T> deserializeList(JSONArray jsonArray, Class<T> clz) {
        if(jsonArray == null){
            return Collections.emptyList();
        }
        return JSON.parseArray(jsonArray.toJSONString(), clz);
    }
    /**
     * 将JSON格式的字符串转换成任意Java类型的对象
     * @param json JSON格式的字符串
     * @param type 任意Java类型
     * @return 任意Java类型的对象
     */
    public static <T> T deserializeAny(String json, TypeReference<T> type) {
        return JSON.parseObject(json, type);
    }
    
    @SuppressWarnings("rawtypes")
	public static String getJsonValue(String json, String key){
		HashMap map = FastJSONHelper.deserialize(json, HashMap.class);
		return (String)map.get(key); 
	}

}