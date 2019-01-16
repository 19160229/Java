package com.jumploo.cms.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.jumploo.cms.log.LogManager;


public class XmlParser {
	private static Logger runLog = LogManager.getLogManager().getRunLog();

	public static Map<String, Object> getMap(String filePath) {
		File file = new File(filePath);
		FileInputStream is = null;
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			runLog.error("", e);
		}
		try {
			return getMap(is);
		} catch (DocumentException e) {
			runLog.error("", e);
		}
		return null;
	}

	public static Map<String, Object> ConvertXmlToMap(String xmlStr)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xmlStr);//字符串转xml,使用dom4j转换
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		sb.append("mobiel client request msg : ").append(doc.asXML());
		List<Element> list = doc.getRootElement().elements();
		parser(list, map);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getMap(InputStream is) throws DocumentException {
		Map<String, Object> map = new HashMap<String, Object>();
		SAXReader read = new SAXReader();
		Document doc = read.read(is);
		StringBuffer sb = new StringBuffer();
		sb.append("mobiel client request msg : ").append(doc.asXML());
		runLog.debug(sb.toString());
		List<Element> list = doc.getRootElement().elements();
		parser(list, map);

		// �൱����ݽ���ʧ��
		if (map.isEmpty()) {
			throw new DocumentException();
		}
		// �õ���ڵ�
		return map;
	}

	@SuppressWarnings("unchecked")
	private static void parser(List<Element> list, Map<String, Object> map) {
		for (int i = 0; i < list.size(); i++) {
			Element e = list.get(i);

			List<Element> tmp = e.elements();
			if (tmp.size() > 0) {
				parser(tmp, map);
			}
			setValue(e, map);
		}
	}

	/**
	 * ��ȡԪ�صĽڵ�
	 * 
	 * @param e
	 * @param map
	 */
	@SuppressWarnings("unchecked")
	private static void setValue(Element e, Map<String, Object> map) {
		getEle(e, map);
		getAtt(e.attributes(), map);
	}

	/**
	 * ��ȡԪ�ص�����
	 * 
	 * @param list
	 * @param map
	 */
	private static void getAtt(List<Attribute> list, Map<String, Object> map) {
		for (int i = 0; i < list.size(); i++) {
			Attribute e = list.get(i);
			map.put(e.getName(), e.getText().trim());
		}
	}

	private static void getEle(Element e, Map<String, Object> map) {
		String value = e.getText().trim();
		if (null != value && !"".equals(value)) {
			map.put(e.getName(), e.getText().trim());
		}
	}



	@SuppressWarnings("rawtypes")
	private static void print(Map<String, Object> map) {
		Iterator ss = map.keySet().iterator();
		while (ss.hasNext()) {
			Object ss1 = ss.next();
			System.out.println(ss1 + ":" + map.get(ss1));
		}
	}

	private static String getString() {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<root>\n");
		sb.append("<os>10</os>\n");
		sb.append("<ua>10</ua>\n");
		sb.append("<vr>001011</vr>\n");
		sb.append("</root>");
		return sb.toString();
	}
}
