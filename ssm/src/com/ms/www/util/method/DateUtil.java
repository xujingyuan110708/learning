package com.ms.www.util.method;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	//2017周一到周五放假的时间
	public static final String   DATEONE="2017-01-02,2017-01-27,2017-01-30,2017-01-31,2017-02-01,2017-02-02,2017-04-03,2017-04-04,2017-05-01,2017-05-29,2017-05-30,2017-10-02,2017-10-03,2017-10-04,2017-10-05,2017-10-06";
	//2017周末上班的时间
	public static final String   DATETWO="2017-01-22,2017-02-04,2017-04-01,2017-05-27,2017-09-30";
	
	
	//2018年将2017年的注掉，写2018年的
	
	
	public static Date getDateByNum(Date currentDate,int num)throws Exception {
		
		Date datelinshi=null;
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		
		int a=0;
		while(true){
			if(datelinshi==null){
				datelinshi=currentDate;
			}else{
				Calendar cal = Calendar.getInstance();
				cal.setTime(datelinshi);
				cal.add(Calendar.DATE, 1);
				datelinshi=cal.getTime();
				
			}
			
			int dayForWeek = dayForWeek(dateFormat.format(datelinshi));
			if(dayForWeek==6||dayForWeek==7){
				if(DATETWO.contains(dateFormat.format(datelinshi))){
					a++;
				}
			}else{
				if(!DATEONE.contains(dateFormat.format(datelinshi))){
					a++;
				}
			}
			
			if(a==num){
				break;
			}
		}
		
		
		
		return datelinshi;
		
	};
	
	 public static int dayForWeek(String pTime) throws Exception {
		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		  Calendar c = Calendar.getInstance();
		  c.setTime(format.parse(pTime));
		  int dayForWeek = 0;
		  if(c.get(Calendar.DAY_OF_WEEK) == 1){
		   dayForWeek = 7;
		  }else{
		   dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		  }
		  return dayForWeek;
		 }
	 
	
}
