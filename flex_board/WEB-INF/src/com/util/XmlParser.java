package com.util;
import java.util.List;
public class XmlParser {
	public static String toXml(List list){
		StringBuffer xml = new StringBuffer();
		for(int i=0;i<list.size();i++){						
			xml.append(((String)list.get(i)).replaceAll("\\<(\\?)[xml](\\w+)(.*)(\\?)\\>", ""));
			// 특수문자는 앞에 \\
			// [xml] xml 세글자
			// [a-z] a부터 z까지 한개의 문자
			// [a-z]+ 한개 이상의 문자
			// [a-z]* 0개 이상의 문자
			// \\w 공백 문자 한개 이상
			// .* 모든 문자 0개 이상
			// () 그룹
		}
		return xml.toString();
	}
}
