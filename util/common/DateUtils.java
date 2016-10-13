package com.yabushan.test.util.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

/**
 * 
 * <code>{@link DateUtils}</code>
 *
 * TODO : document me
 *
 * @author yabushan
 * @date 2016-1-1
 */
public abstract class DateUtils
{

	static Logger logger = Logger.getLogger(DateUtils.class.getName());
    public static String YYYY_MM_DD_HH_MM_SS="yyyy-MM-dd HH:mm:ss";
    public static void main(String[] args) {
		System.out.println(getCurrentDate());//获取当前日期
		System.out.println(formatDatatoString(new Date(),1));
		System.out.println(formatDatatoString(new Date(),2));
		System.out.println(formatDatatoString(new Date(),3));
	}
    /**
     * 获取当前日期
     * @return
     */
	public static Date getCurrentDate()
	{
		Calendar now = Calendar.getInstance();
		return now.getTime();
	}

	public static Date parseDate(String date, String... pattern)
			throws ParseException
	{
		return DateUtils.parseDate(date, pattern);

	}

	public static Date[] getDateRangeOfMonth(int year, int month)
	{
		month = month - 1;
		Calendar rightNow = Calendar.getInstance();
		rightNow.set(year, month, 1, 0, 0, 0);
		Date startDate = rightNow.getTime();
		rightNow.set(year, month + 1, 1, 0, 0, -1);
		Date endDate = rightNow.getTime();
		return new Date[] { formatDate(startDate), formatDate(endDate) };
	}

	public static int[] getNowSingleObject()
	{
		Calendar rightNow = Calendar.getInstance();
		return new int[] { rightNow.get(Calendar.DAY_OF_MONTH),
				rightNow.get(Calendar.MONTH) + 1, rightNow.get(Calendar.YEAR) };
	}

	public static String getNowM()
	{
		SimpleDateFormat bartDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm");
		Date now = new Date();
		String str = bartDateFormat.format(now).toString();
		return str;
	}

	public static Date formatDate(Date date)
	{
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date convert = null;
		try
		{
			convert = bartDateFormat.parse(bartDateFormat.format(date));
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convert;
	}

	public static Date formatDate(Date date, int i)
	{
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (i == 1)
		{
			bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		} else if (i == 2)
		{
			bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		}else if (i == 3)
		{
			bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		Date convert = null;
		try
		{
			convert = bartDateFormat.parse(bartDateFormat.format(date));
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convert;
	}
	public static Date getDate(java.sql.Timestamp timestamp) {
		Calendar c = new GregorianCalendar();
	    c.setTimeInMillis(timestamp.getTime());
	
		return c.getTime();
	}
	/**
	 * @param date
	 *            需要格式化的日期
	 * @param i
	 *            1：yyyy-MM-dd 2：yyyy-MM-dd HH:mm 3:HH:mm else:yyyy-MM-dd
	 * @return 规定格式的字符串
	 */
	public static String formatDatatoString(Date date, int i)
	{
		String result = "";
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (date == null)
			return "";
		if (i == 1)
		{  
			bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		} else if (i == 2)
		{
			bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		} else if (i == 3)
		{
			bartDateFormat = new SimpleDateFormat("HH:mm");
		} else if (i == 4)
		{
			bartDateFormat = new SimpleDateFormat("MM-dd HH:mm");
		} else

		if (i == 5)
		{
			bartDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
		} else if (i == 6)
		{
			bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else if (i == 7)
		{
			bartDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		} else if (i == 8)
		{
			bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
		}else if(i ==9){
			bartDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		}else if(i ==10){
			bartDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
		}else if(i ==11){
			bartDateFormat = new SimpleDateFormat("yyyyMMdd");
		} else if (i == 12)
		{
			bartDateFormat = new SimpleDateFormat("HH:mm:ss");
		}

		result = bartDateFormat.format(date).toString();
		return result;
	}

	/**
	 * 将字符串格式化成日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date formatDate(String date)
	{
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date convert = null;
		try
		{
			convert = bartDateFormat.parse(date);
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convert;
	}
	public static Date formatDate(String date,String format)
	{
		SimpleDateFormat bartDateFormat = new SimpleDateFormat(format);
		Date convert = null;
		try
		{
			convert = bartDateFormat.parse(date);
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convert;
	}

	public static Date formatDate(String date, int i)
	{
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (i == 1)
		{
			bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		} else if (i == 2)
		{
			bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		} else if (i == 3)
		{
			bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else if (i == 4)
		{
			bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

		} else if (i == 5)
		{
			bartDateFormat = new SimpleDateFormat("HH:mm:ss");
		}else if(i ==6){
			bartDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		}

		Date convert = null;
		try
		{
			convert = bartDateFormat.parse(date);
		} catch (ParseException e)
		{
			logger.warn(e.getMessage());
		}
		return convert;
	}

	public static boolean isSameDay(Date date1, Date date2, int i)
	{
		String s1 = formatDatatoString(date1, i);
		String s2 = formatDatatoString(date2, i);
		return s1.equalsIgnoreCase(s2);
	}

	public static boolean isToday(Date date1, int i)
	{
		Calendar today = Calendar.getInstance();
		return isSameDay(today.getTime(), date1, i);
	}

	public static Long formatDateToLong(Date date)
	{

		if (date != null)
		{
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			return now.getTimeInMillis();
		} else
		{
			return 0L;
		}
	}

	public static Date formatLongToDate(Long millis)
	{

		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(millis);
		return now.getTime();
	}
	/**
	 * 
	 * @param longTime
	 * @return
	 */
	public static String getTimeStr(Long longTime)
	{
		String result = "00:00:00";
		try
		{
			int hour = (longTime.intValue() / 3600) % 24;
			int minite = (longTime.intValue() / 60) % 60;
			int second = (longTime.intValue() % 60);
			String hourStr = hour < 10 ? ("0" + hour) : hour + "";
			String miniteStr = minite < 10 ? ("0" + minite) : minite + "";
			String secondStr = second < 10 ? ("0" + second) : second + "";
			result = hourStr + ":" + miniteStr + ":" + secondStr;
		} catch (Exception e)
		{
			logger.error("", e);
		}

		return result;

	}
/**
 * 
 * @param strTime
 * @return
 */
	public static Long getStrLongTime(String strTime)
	{
		Long result = 0L;
		String[] strs = strTime.split(":");
		try
		{
			int hour = Integer.parseInt(strs[0]);
			int minite = Integer.parseInt(strs[1]);
			int second = Integer.parseInt(strs[2]);
			result = Long.valueOf((hour * 60 * 60) + (minite * 60) + second);
		} catch (Exception e)
		{
			logger.error("", e);
		}
		return result;
	}
	/**
	 * 将 java.util.Date 对象转换为 java.sql.Timestamp 对象。
	 * 
	 * @param date
	 *            java.util.Date对象
	 * @return java.sql.Timestamp对象，如果参数为 null 则返回 null。
	 */
	public static java.sql.Timestamp toSqlTimestamp(java.util.Date date) {
		if (date == null) {
			return null;
		}
		return new java.sql.Timestamp(date.getTime());
	}
	
	/**
	 * @data:2015-01-09
	 * @param date
	 * @param day
	 * @return
	 * 日期增加指定天数
	 */
	public static Date addDay(Date date,int day){
			Calendar cal=Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_YEAR,day);
			return cal.getTime();
		}
}
