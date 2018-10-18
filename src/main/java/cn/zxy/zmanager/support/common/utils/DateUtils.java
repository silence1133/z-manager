package cn.zxy.zmanager.support.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具类
 * @author 001316
 * @Date   2017/8/23
 */
public class DateUtils {
	
	/**
	 *  DATE PATTERN 
	 */
    public static final String PATTERN_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_YYYYMMDD_HHMM = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_YYYYMMDD = "yyyy-MM-dd";
    public static final String PATTERN_YYYY = "yyyy";
    public static final String PATTERN_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	/**
	 * 其他时间值转换为毫秒单位：秒
	 */
	public static final long UNIT_SECOND_TIME = 1000;
	/**
	 * 其他时间值转换为毫秒单位：分钟
	 */
	public static final long UNIT_MINUS_TIME = 60 * UNIT_SECOND_TIME;
	/**
	 * 其他时间值转换为毫秒单位：小时
	 */
	public static final long UNIT_HOUR_TIME = 60 * UNIT_MINUS_TIME;
	/**
	 * 其他时间值转换为毫秒单位：天
	 */
	public static final long UNIT_DAY_TIME = 24 * UNIT_HOUR_TIME;

	public static Date getCurrentDate() {
		LocalDateTime localDateTime = LocalDateTime.now();
	    ZoneId zone = ZoneId.systemDefault();
	    Instant instant = localDateTime.atZone(zone).toInstant();
	    Date date = Date.from(instant);
	    
	    return date;
	}
	
	public static Date calNaturalMonth(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}

	public static Date getLastMonthFirstDay(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH,-1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}

	public static Date getLastMonthLastDay(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 0);
		return c.getTime();
	}


	public static Date dateAfter(Date date, int field, int delta){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field,delta);
		return cal.getTime();
	}

	public static Date calLastNaturalWeek(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		c.add(Calendar.DAY_OF_MONTH,-7);
		return c.getTime ();
	}

	public static Date calNaturalWeek(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return c.getTime ();
	}

	public static List<String> getFormatDateBetweenDates(Date begin, Date end) {
		List<String> result = new ArrayList<String>();
		Calendar tempStart = Calendar.getInstance();
		tempStart.setTime(begin);
		while(begin.getTime()<=end.getTime()){
			result.add(parseDateToStr(tempStart.getTime(),PATTERN_YYYYMMDD));
			tempStart.add(Calendar.DAY_OF_YEAR, 1);
			begin = tempStart.getTime();
		}
		return result;
	}

	public static List<Date> getBetweenDates(Date begin, Date end) {
		List<Date> result = new ArrayList<Date>();
		Calendar tempStart = Calendar.getInstance();
		tempStart.setTime(begin);
		while(begin.getTime()<=end.getTime()){
			result.add(tempStart.getTime());
			tempStart.add(Calendar.DAY_OF_YEAR, 1);
			begin = tempStart.getTime();
		}
		return result;
	}


	public static Date dateHoursAfterCurrent(int hours){
		return dateHoursAfter(new Date(),hours);
	}

	public static Date dateHoursAfter(Date date, int hours){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR_OF_DAY,hours);
		return cal.getTime();
	}

	public static Date dateAfter(Date date, int days){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH,days);
		return cal.getTime();
	}

	public static Date dateAfterCurrent(int days){
		return dateAfter(new Date(),days);
	}

	/**
	 *
	 * @param date
	 * @param format
	 * @return
	 */
    public static String parseDateToStr(Date date, String format) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    /**
     * 返回格式：yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String parseDateToStr(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(PATTERN_YYYYMMDD_HHMMSS);
        return formatter.format(date);
    }

	/**
	 * 返回格式：Date
	 * @param str
	 * @return
	 */
	public static Date parseStrToDate(String str) {
		if(str == null || "".equals(str)) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(PATTERN_YYYYMMDD_HHMMSS);
		try {
			return formatter.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 返回格式：Date
	 * @param str
	 * @param format 格式
	 * @return
	 */
	public static Date parseStrToDate(String str, String format) {
		if(str == null || "".equals(str)) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		try {
			return formatter.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

    /**
	 * 特定日期和服务器日期相差的天数
	 * @param source 要比较的日期
	 * @return 天数，之后大于零，之前小于零
	 */
	public static int daysBeforeNow(final Date source) {
		// 如果要比较的source不存在
		if (source == null) {
			return 0;
		}
		Calendar now = Calendar.getInstance();
		Calendar old = Calendar.getInstance();
		// 设置时分秒为0:0:0
		old.setTime(source);
		old.set(Calendar.HOUR_OF_DAY, 0);
		old.set(Calendar.MINUTE, 0);
		old.set(Calendar.SECOND, 0);
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		// 获取相差描述
		long l = old.getTimeInMillis() - now.getTimeInMillis();
		// 转换程天数
		return BigDecimal.valueOf(l).divide(BigDecimal.valueOf(UNIT_DAY_TIME), RoundingMode.HALF_UP).intValue();
	}

	/**
	 * 特定日期1  和  特定日期2  相差的天数
	 * @param source1 要比较的日期
	 * @param source2
	 * @return 天数，之后大于零，之前小于零 
	 */
	public static int daysBefore(final Date source1,final Date source2) {
		// 如果要比较的source不存在
		if (source1 == null || source2 == null) {
			return 0;
		}
		Calendar now = Calendar.getInstance();
		Calendar old = Calendar.getInstance();
		// 设置时分秒为0:0:0
		old.setTime(source1);
		old.set(Calendar.HOUR_OF_DAY, 0);
		old.set(Calendar.MINUTE, 0);
		old.set(Calendar.SECOND, 0);
		
		now.setTime(source2);
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		// 获取相差描述
		long l = old.getTimeInMillis() - now.getTimeInMillis();
		// 转换程天数
		return BigDecimal.valueOf(l).divide(BigDecimal.valueOf(UNIT_DAY_TIME), RoundingMode.HALF_UP).intValue();
	}

	/**
	 * 计算两个时间相差的小时，left-right
	 * @param left
	 * @param right
	 * @return
	 */
	public static long timeDistanceHours(Date left,Date right){
		return (left.getTime()-right.getTime())/UNIT_HOUR_TIME;//计算差多少小时
	}

	/**
	 * 计算两个时间相差的秒，left-right
	 * @param left
	 * @param right
	 * @return
	 */
	public static long timeDistanceSeconds(Date left,Date right){
		return (left.getTime()-right.getTime())/UNIT_SECOND_TIME;
	}
	
	/**
	 * 计算两个时间相差的毫秒数，left-right
	 * @param left
	 * @param right
	 * @return
	 */
	public static long timeDistanceMillis(Date left,Date right){
		return (left.getTime()-right.getTime());
	}
	
	/**
	 * 计算与当前时间相差的毫秒数
	 * @param left 待比较时间
	 * @return
	 */
	public static long timeDistanceNowMillis(Date left){
		return (left.getTime()-System.currentTimeMillis());
	}
	
	/**
	 *  得到相差的天数,开始时间应该小于结束时间
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return 天数
	 */
	public static int getDiffTime(long startTime, long endTime) {
		Calendar startCalender = Calendar.getInstance();
		startCalender.setTimeInMillis(startTime);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTimeInMillis(endTime);
		int r = 0;
		while (!startCalender.after(endCalendar)) {
			r++;
			startCalender.add(Calendar.DATE, 1); // 比较天数，日期+1
		}
		return r;
	}

	public static Date getDate(Date startDate, int year) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(startDate);
		calender.set(Calendar.YEAR, calender.get(Calendar.YEAR) + year);
		return calender.getTime();
	}
}
