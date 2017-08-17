package com.ms.www.util.method;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 关于日期处理方法类
 * @author zxj
 *
 */
public class DateMethod {
	/**
	 * 获取指定日期星期几
	 * @param specifiedDay       指定日期
	 * @return
	 */
	public static String getWeekOfDate(String specifiedDay) throws Exception {
		Date date = null;  
        try {  
            date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
	}

	/**
	 * 获得指定日期的前n天 
	 * @param specifiedDay    指定日期
	 * @param pre             指定日期的前pre天数
	 * @return
	 */
	public static String getSpecifiedDayBefore(String specifiedDay, int pre) throws Exception {
		Calendar c = Calendar.getInstance();  
        Date date = null;  
        try {  
            date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        c.setTime(date);  
        int day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day - pre);  
  
        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());  
        return dayBefore; 
	}

	/**
	 * 获得指定日期的后n天 
	 * @param specifiedDay    指定日期
	 * @param next            定日期的后next天数
	 * @return
	 */
	public static String getSpecifiedDayAfter(String specifiedDay, int next) throws Exception {
		Calendar c = Calendar.getInstance();  
        Date date = null;  
        try {  
            date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        c.setTime(date);  
        int day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day + next);  
  
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());  
        return dayAfter; 
	}

}
