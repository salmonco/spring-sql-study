package com.my.util;

public class ComUtil {
	
	public static String getParameter(String value){

		if(value == null) return null;

		StringBuffer strBuff = new StringBuffer();

		for(int i = 0; i < value.length(); i++){
			char c = value.charAt(i);

			switch(c){
				case 60: // '<'
					strBuff.append("&lt;");
					break;
		        case 62: // '>'
		        	strBuff.append("&gt;");
		        	break;
//		        case 38: // '&'
//		            strBuff.append("&amp;");
//		            break;
		        case 34: // '"'
		        	strBuff.append("&quot;");
		        	break;
				case 39: // '\''
					strBuff.append("&apos;");
					break;
				default:
					strBuff.append(c);
					break;
			}
		}
		value = strBuff.toString();

		return value;
	}
}
