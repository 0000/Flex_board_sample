package com.util;
import java.util.List;
public class XmlParser {
	public static String toXml(List list){
		StringBuffer xml = new StringBuffer();
		for(int i=0;i<list.size();i++){						
			xml.append(((String)list.get(i)).replaceAll("\\<(\\?)[xml](\\w+)(.*)(\\?)\\>", ""));
			// Ư�����ڴ� �տ� \\
			// [xml] xml ������
			// [a-z] a���� z���� �Ѱ��� ����
			// [a-z]+ �Ѱ� �̻��� ����
			// [a-z]* 0�� �̻��� ����
			// \\w ���� ���� �Ѱ� �̻�
			// .* ��� ���� 0�� �̻�
			// () �׷�
		}
		return xml.toString();
	}
}
