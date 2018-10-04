package cn.zxy.zmanager.support.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author chenzhichao 000178
 * @date 2017/6/17
 */
public class HttpParamUtils {
    /**
     * 真实的http错误码
     */
    private static final String REAL_HTTP_STATUS = "realHttpStatus";
    /**
     * 获取请求的参数
     * @param request 请求参数
     * @return
     */
    public static Map getParameterMap(HttpServletRequest request) {
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        Map<String, Object> returnMap = new HashMap<>();
        Iterator entries = properties.entrySet().iterator();
        String value;
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = StringUtils.EMPTY;
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                value = StringUtils.join(values, ",");
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }

    /**
     *  设置HTTP真实的错误码
     * @param request 请求参数
     */
    public static void setRealStatusCode(HttpServletRequest request, int statusCode) {
        request.setAttribute(REAL_HTTP_STATUS, statusCode);
    }
}
