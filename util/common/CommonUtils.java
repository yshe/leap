package com.yabushan.test.util.common;

import java.util.Calendar;

import org.apache.poi.hssf.record.formula.functions.Isnumber;

/**
 * 普通工具类包
 * @author yabushan
 *
 */
public class CommonUtils {
	
	/**
	 * 字符串转数组
	 * @param string 要转换的字符串
	 * @param separator 分隔符
	 * @return
	 */
	public static String[] stringToArray(String string,String separator){
		return string.split(separator);
	}
	
	/**
	 * 数组转字符串
	 * @param array 要转换的数组
	 * @param separator 分隔符
	 * @return
	 */
	public static String arrayToString(int[] array,String separator){
		String result="";
		for (int i = 0; i < array.length; i++) {
			result+=String.valueOf(array[i]);
			if(i<array.length-1){result+=separator;}//每个字符以 separator隔开
		}
		return result;
	}
	
	/**
	 * 将整型值格式化为指定长度的字符串
	 * @param num : 要格式的整型值
	 * @param len : 格式长度
	 * @return 返回格式后的字符串
	 */
	public static String getNumStr(int num,int len){
		String str = String.valueOf(num);//转换为字符串
		String numStr ="";
		int length = len -str.length();//在字符串之前补0的长度
		if(length<=0){
			numStr = str;
		}else{
			for(int i=0;i<length;i++){
				str = "0"+str;
			}
			numStr = str;
		}
		return numStr;
	}
	
	/**
	 * 判断字符串是否包含字母
	 * @param str
	 * @return
	 */
	public boolean isHasEn(String str) {
		char cArr[] = str.toCharArray();//将字符串转换为字符数组
		boolean b =false;
		StringBuffer sb =new StringBuffer("");
		StringBuffer sb2 =new StringBuffer("");
		for(int i=0;i<cArr.length;i++){
			//调用String类的hashCode()方法也能获得字符的ASCII码
			//int ascii = String.valueOf(cArr[i]).hashCode();
			int ascii = (int)cArr[i];//强制转换可以直接得到字符的ASCII码
			System.out.println(ascii);
			//英文字符的 ASCII码范围，大写字母A-Z的范围65-90，小写字母a-z的范围97-122
			if((ascii>=65&&ascii<=90)||(ascii>=97&&ascii<=122)){
				sb.append(cArr[i]);	//将每个英文字母添加到StringBuffer对象中
			}
			else{
				sb2.append(cArr[i]);
			}
		}
		if(!sb.toString().equals(""))//如果保存英文字母的字符串不为""，说明该字符串包含英文字母
			return true;
		else
			return false;
	
	}

	/**
	 * 将长整型的数字分位显示
	 * @param longValue
	 * @param digit
	 * @return
	 */
	public static String getFormatStr(long longValue,int digit) {
		//将long类型的值转换为可动态修改的StringBuffer对象
		StringBuffer sb = new StringBuffer(String.valueOf(longValue));
		sb =sb.reverse();			//将字符串反转
		int l = sb.length();
		if(digit==0){				//如果分位位数为0，设置字符串的长度为分位位数
			digit=l;
		}
		int count = 0;
		/**计算出插入的分为符个数*/
		if(l%digit==0)
			count=l/digit-1;
		else
			count=l/digit;
		for(int i= 0;i<count;i++){
			sb =sb.insert((i+1)*digit+i ,",");//插入分位符
		}
		return sb.reverse().toString();
	}
	
	/**
	 * 过滤字符
	 * @param sourceStr
	 * @return
	 */
	public static String filterDandrousChar(String sourceStr){
			sourceStr = sourceStr.replaceAll("&", "&amp;");	//过滤字符&
			sourceStr = sourceStr.replaceAll(";", "");		//过滤字符;
			sourceStr = sourceStr.replaceAll("'", "");		//过滤字符'
			sourceStr = sourceStr.replaceAll("<", "&lt;");	//过滤字符<
			sourceStr = sourceStr.replaceAll(">", "&gt");	//过滤字符>
			sourceStr = sourceStr.replaceAll("/", "");		//过滤字符/
			sourceStr = sourceStr.replaceAll("%", "");		//过滤字符%
			sourceStr = sourceStr.replaceAll("=", "");		//过滤字符=
			return sourceStr;
	}
	
	
	
/**
 * 	
 */
// 简体中文的编码范围从B0A1（45217）一直到F7FE（63486）  
  private final static  int BEGIN = 45217;  
  private final static int END = 63486;  

  // 按照声 母表示，这个表是在GB2312中的出现的第一个汉字，也就是说“啊”是代表首字母a的第一个汉字。  
  // i, u, v都不做声母, 自定规则跟随前面的字母  
private static char[] chartable = { '啊', '芭', '擦', '搭', '蛾', '发', '噶', '哈', '哈', '击', '喀', '垃', '妈', '拿', '哦', '啪', '期', '然', '撒', '塌', '塌', '塌', '挖', '昔', '压', '匝', };  

  // 二十六个字母区间对应二十七个端点  
  // GB2312码汉字区间十进制表示  
private static  int[] table = new int[27];  

   // 对应首字母区间表  
private static char[] initialtable = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 't', 't', 'w', 'x', 'y', 'z', };  

public static String getShortPhonetic(String sourceStr) {
		  String shortPhonetic="";
	    // 初始化  
	        for (int i = 0; i < 26; i++) {  
	            table[i] = gbValue(chartable[i]);// 得到GB2312码的首字母区间端点表，十进制。  
	        }  
	        table[26] = END;// 区间表结尾  
	    
		return shortPhonetic;
	}
	// ------------------------public方法区------------------------  
    // 根据一个包含汉字的字符串返回一个汉字拼音首字母的字符串 最重要的一个方法，思路如下：一个个字符读入、判断、输出  
  
    public static String cn2py(String SourceStr) {  
        String Result = "";  
        int StrLength = SourceStr.length();  
        int i;  
        try {  
            for (i = 0; i < StrLength; i++) {  
                Result += Char2Initial(SourceStr.charAt(i));  
            }  
        } catch (Exception e) {  
            Result = "";  
            e.printStackTrace();  
        }  
        return Result;  
    }  
  
    // ------------------------private方法区------------------------  
    /** 
     * 输入字符,得到他的声母,英文字母返回对应的大写字母,其他非简体汉字返回 '0' 　　* 　　 
     */  
    private static char Char2Initial(char ch) {  
        // 对英文字母的处理：小写字母转换为大写，大写的直接返回  
        if (ch >= 'a' && ch <= 'z') {  
            return (char) (ch - 'a' + 'A');  
        }  
        if (ch >= 'A' && ch <= 'Z') {  
            return ch;  
        }  
        // 对非英文字母的处理：转化为首字母，然后判断是否在码表范围内，  
        // 若不是，则直接返回。  
        // 若是，则在码表内的进行判断。  
        int gb = gbValue(ch);// 汉字转换首字母  
        if ((gb < BEGIN) || (gb > END))// 在码表区间之前，直接返回  
        {  
            return ch;  
        }  
        int i;  
        for (i = 0; i < 26; i++) {// 判断匹配码表区间，匹配到就break,判断区间形如“[,)”  
            if ((gb >= table[i]) && (gb < table[i + 1])) {  
                break;  
            }  
        }  
        if (gb == END) {// 补上GB2312区间最右端  
            i = 25;  
        }  
        return initialtable[i]; // 在码表区间中，返回首字母  
    }  
  
    /** 
     * 取出汉字的编码 cn 汉字 　　 
     */  
    private static int gbValue(char ch) {// 将一个汉字（GB2312）转换为十进制表示。  
        String str = new String();  
        str += ch;  
        try {  
            byte[] bytes = str.getBytes("GB2312");  
            if (bytes.length < 2) {  
                return 0;  
            }  
            return (bytes[0] << 8 & 0xff00) + (bytes[1] & 0xff);  
        } catch (Exception e) {  
            return 0;  
        }  
    }  	
	
//==============================================================end
	
	/**
	 * 检查字符串是否包含数字
	 * @param str
	 * @return
	 */
	public static boolean isHasNum(String str) {
		//要检查的字符串
		 boolean hasNum;		//是否包含数字
		 String othersStr;	//去掉数字后的字符串
		char cArr[] = str.toCharArray();//将字符串转换为字符数组
		StringBuffer sbNum =new StringBuffer("");
		StringBuffer sbOthers =new StringBuffer("");
		for(int i=0;i<cArr.length;i++){
			//调用String类的hashCode()方法也能获得字符的ASCII码
			//int ascii = String.valueOf(cArr[i]).hashCode();
			int ascii = (int)cArr[i];//强制转换可以直接得到字符的ASCII码
			//数字的 ASCII码范围在48-57之间
			if(ascii>=48&&ascii<=57){
				sbNum.append(cArr[i]);//将每个数字添加到StringBuffer对象中
			}
			else{
				sbOthers.append(cArr[i]);
			}
		}
		othersStr=sbOthers.toString();
		if(!sbNum.toString().equals(""))
			hasNum=true;
		else
			hasNum=false;
		return hasNum;
	}
	
	/**
	 * 判断用户输入的日期是不是等于今天的日期
	 * 
	 * @param dateStr 用户输入的日期
	 * @return
	 */
	public static boolean isToday(String dateStr) {
		 boolean today;	//判断是否为今天
		 String cue;		//提示信息
		String dateArr[] = dateStr.split("-");	//将日期字符串分解为数组
		int year =Integer.parseInt(dateArr[0]);
		int month =Integer.parseInt(dateArr[1]);		
		int date = Integer.parseInt(dateArr[2]);
		Calendar now = Calendar.getInstance();	//获得系统当前时间的Calendar对象
		int nowYear = now.get(now.YEAR);		//获得当前时间的年
		int nowMonth = now.get(now.MONTH)+1;	//获得当前时间的月
		int nowDate = now.get(now.DAY_OF_MONTH);//获得当前时间的日
		if(year==nowYear&&month==nowMonth&&date==nowDate){//如果年月日的值都相同
			cue="输入的日期为当前日期！";
			today=true;
		}else{
			cue="输入的日期不是当前日期！";
			today=false;
		}
		return today;
	}
		
	/**
	 * 判断输入的是否为数字
	 * @param numStr
	 * @return
	 */
	public static boolean isNumber(String numStr) {
		boolean number=false;
		char cArr[]= numStr.toCharArray();		//将字符串转换为字符数组
		StringBuffer sb = new StringBuffer("");	//创建动态字符串对象
		for(int i=0;i<cArr.length;i++){
			int ascii = (int)cArr[i];			//将字符强制转换为int值，该值为字符的ASCII码
			if(ascii>=48&&ascii<=57){			//数字0-9的ASCII码范围在48-57之间
				sb.append(cArr[i]);				//条件满足，将字符添加在StringBuffer字符串末尾
			}
		}
		if(sb.length()==cArr.length){			//如果StringBuffer字符串的长度等于字符数组的长度
			number=true;						//该字符串为数字
		}
		else{
			number=false;
		}
		return number;
	}
	
	
	public static void main(String[] args) {
		//System.out.println(getFormatStr(1234567997, 4));
		//存在问题 System.out.println(cn2py("重庆重视"));  //测试获取首字母
		System.out.println(isHasNum("sdfd232"));
		System.out.println(isToday("2016-06-18"));
		System.out.println(isNumber("123"));
	}
	
}

