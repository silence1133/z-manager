package cn.zxy.zmanager.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by 001097 on 2017/10/1.
 */
public class CommonUtils {

    private static final BigDecimal BIG_HUNDRED = new BigDecimal(100);


    public static boolean isListEmpty(List list) {
        return (list == null || list.size() == 0);
    }


    /**
     * 生成6位随机数
     *
     * @param
     * @return
     */
    public static String createOrderToken() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }

    /**
     * (如果整数不保留两位小数)
     *
     * @param fee
     * @return
     */
    public static String strFormat(Long fee) {
        if (null == fee) {
            return "0";
        }
        BigDecimal count = new BigDecimal(fee);
        DecimalFormat df = new DecimalFormat("#0.##");
        return df.format(count.divide(BIG_HUNDRED, 2, BigDecimal.ROUND_HALF_UP));
    }

    /**
     * 获取几天之前或者几天之后的日期
     * @param minute
     * @return
     */
    public static Date getDateByMinute(int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    /**
     *获取剩余时分秒
     * @param minute
     * @return
     */
    public static String getFormatDate(Date date,int minute) {
        StringBuilder builder=new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        long time=(calendar.getTime().getTime()-System.currentTimeMillis())/1000;
        time=time<0?0:time;
        int dd=(int)time/(3600*24);
        int hh=(int)((time-dd*3600*24)/3600);
        int MM =(int)((time-dd*3600*24-hh*3600)/60);
        builder.append(dd).append("天").append(hh).append("小时").append(MM).append("分");
        return builder.toString();
    }


    /**
     * 对集合分页
     * @param page 页码
     * @param pageSize 每页条数
     * @param list 集合
     * @param <T>
     * @return
     */
    public static <T> List<T> pageList(int page,int pageSize,List<T> list){
        if(isListEmpty(list) || page < 1){
            return null;
        }
        int listSize = list.size();
        int start = (page-1) * pageSize;
        int end = (page-1) * pageSize + pageSize;

        if(listSize<=start){
            return null;
        }else if(listSize > start && listSize < end){
            end = listSize;
        }
        return list.subList(start,end);
    }

}
