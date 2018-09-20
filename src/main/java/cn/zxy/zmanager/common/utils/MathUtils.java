package cn.zxy.zmanager.common.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * 数学计算工具类
 * @author 001316
 * @Date   2017/10/26
 */
public class MathUtils {
	private static final int DEF_DIV_SCALE_TWO = 2;
	
	public static final int DEF_DIV_SCALE_FOUR = 4;

	
	public static final String ZERO_PERCENT = "0.00%";
	
	/**
     * 金额转换为长整型，如元转换为分，四舍五入
     * @param value 数值
     * @return
     */
    public static Long transformMoney(BigDecimal value) {
    	if(value == null) {
    		return 0L;
    	}
		return value.multiply(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
    }
    
    /**
     * 金额转换，如分转换为元
     * @param value
     * @return
     */
    public static BigDecimal convertMoney(Long value) {
    	if(value == null) {
    		return new BigDecimal("0");
    	}
    	BigDecimal val = new BigDecimal(value.toString());
		return val.divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP);
    }
	
    /**
	 * 转换比值为百分比
	 * @param number1
	 * @param number2
	 * @param scale 表示表示需要精确到小数点以后几位
	 * @return
	 */
	public final static String transformPercent(BigDecimal number1, BigDecimal number2, int scale) {
		if(number1 == null || number2 == null) {
			return ZERO_PERCENT;
		}
		NumberFormat percentFormat = NumberFormat.getPercentInstance();
		// 设置小数位
        percentFormat.setMinimumFractionDigits(2);
        String format = percentFormat.format(div(number1, number2, scale));
	    return format;
	}
    
    /**
	 * 转换比值为百分比
	 * @param number1
	 * @param number2
	 * @param scale 表示表示需要精确到小数点以后几位
	 * @return
	 */
	public final static String transformPercent(Long number1, Long number2, int scale) {
		if(number1 == null || number2 == null || Long.compare(number2, 0L) == 0) {
			return ZERO_PERCENT;
		}
		NumberFormat percentFormat = NumberFormat.getPercentInstance();
		// 设置小数位
        percentFormat.setMinimumFractionDigits(2);
        String format = percentFormat.format(div(new BigDecimal(String.valueOf(number1)), new BigDecimal(String.valueOf(number2)), scale));
	    return format;
	}
	
	/**
	 * 提供精确的加法运算。
	 * @param b1 被加数
	 * @param b2 加数
	 * @return 两个参数的和
	 */
	public static BigDecimal add(BigDecimal b1,BigDecimal b2){
		return b1.add(b2);
	}

	/**
	 * 提供精确的减法运算。
	 * @param b1 被减数 
	 * @param b2 减数
	 * @return 两个参数的差
	 */
	public static BigDecimal sub(BigDecimal b1,BigDecimal b2){
		return b1.subtract(b2);
	}

	/**
	 * 提供精确的乘法运算。
	 * @param b1 被乘数
	 * @param b2 乘数
	 * @return 两个参数的积
	 */
	public static BigDecimal mul(BigDecimal b1,BigDecimal b2){
		return b1.multiply(b2);
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
	 * 小数点以后2位，以后的数字四舍五入。
	 * @param b1 被除数
	 * @param b2 除数
	 * @return 两个参数的商
	 */
	public static BigDecimal div(BigDecimal b1,BigDecimal b2){
		return div(b1,b2,DEF_DIV_SCALE_TWO);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
	 * 定精度，以后的数字四舍五入。
	 * @param b1 被除数 
	 * @param b2 除数 
	 * @param scale 表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static BigDecimal div(BigDecimal b1,BigDecimal b2,int scale){
		if(scale<0){
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP);
	}
}
