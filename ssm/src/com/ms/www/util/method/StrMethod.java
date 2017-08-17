package com.ms.www.util.method;

/**
 * 有关字符串处理方法类
 * @author zxj
 *
 */
public class StrMethod {
	/**
	 * 段前空两个字符(页面->数据库)
	 * @param str                     待编辑字符串 
	 * @return  String                已经编辑的字符串
	 */
	public static String indent(String str){
		if(str != null && !"".equals(str)){
			StringBuffer temp = new StringBuffer("　　");
			str = str.replaceAll("　","");
			String[] strs = str.split("\r\n");
			for(int i=0;i<strs.length;i++){
				if(!"".equals(strs[i].trim())){
					if(i == strs.length-1){
						temp.append(strs[i].trim());
					}else{
						temp.append(strs[i].trim()+"\r\n　　");
					}
				}
			}
			return temp.toString();
		}
		return null;
	}
	
	/**
	 * 格式化字符串(数据库->页面)
	 * @param str                     待编辑字符串 
	 * @return String                 已经编辑的字符串
	 */
	public static String formatStr(String str){
		if(str != null && !"".equals(str)){
			StringBuffer temp = new StringBuffer("&nbsp;&nbsp;&nbsp;&nbsp;");
			str = str.replaceAll("　","");
			String[] strs = str.split("\r\n");
			for(int i=0;i<strs.length;i++){
				if(!"".equals(strs[i].trim())){
					if(i == strs.length-1){
						temp.append(strs[i].trim());
					}else{
						temp.append(strs[i].trim()+"<br/>&nbsp;&nbsp;&nbsp;&nbsp;");
					}
				}
			}
			return temp.toString();
		}
		return null;
	}

}
