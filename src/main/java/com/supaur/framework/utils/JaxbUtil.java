package com.supaur.framework.utils;


import org.springframework.util.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * xml和对象转化工具
 * @author Patrick Shen
 */
public class JaxbUtil {
	/**
	 * xml文件配置转换为对象
	 * @param xmlPath  xml文件路径
	 * @param load    java对象.Class
	 * @return    java对象
	 * @throws JAXBException
	 * @throws IOException
	 */
	public static Object xmlToBean(String xmlPath,Class<?> load) throws JAXBException, IOException{
		JAXBContext context = JAXBContext.newInstance(load);
		Unmarshaller unmarshaller = context.createUnmarshaller();

		Object object = unmarshaller.unmarshal(new File(xmlPath));
		return object;
	}

	public static Object xmlToBean(InputStream in, Class<?> load) throws JAXBException, IOException{
		JAXBContext context = JAXBContext.newInstance(load);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Object object = unmarshaller.unmarshal(in);
		return object;
	}
	/**
	 * xml转对象
	 * @param obj
	 * @return
	 */
	public static String getXmlFromObject(Object obj){
		return getXmlFromObjectSchema(obj,obj.getClass(),true);
	}
	public static String getXmlFromObject(Object obj,Class<?> c){
		return getXmlFromObjectSchema(obj,c,true);
	}
	/**
	 * xml转对象
	 * @param obj
	 * @param hasSchema
	 * @return
	 */
	public static String getXmlFromObjectSchema(Object obj,Class<?> c,Boolean hasSchema){
		return getXmlFromObjectSchema(obj, c,hasSchema, System.getProperty("file.encoding"));
	}
	/**
	 * xml转对象
	 * @param obj
	 * @param hasSchema
	 * @param encoding
	 * @return
	 */
	public static String getXmlFromObjectSchema(Object obj,Class<?> c,Boolean hasSchema,String encoding){
		String xml = "";
		if(obj==null){
			return xml;
		}
		try {
			JAXBContext context = JAXBContext.newInstance(c);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_ENCODING, encoding);
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_FRAGMENT, false);
			if(!hasSchema){
				m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, false);
				m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, false);
			}
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			m.marshal(obj, outputStream);
			xml = outputStream.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return xml;
	}
	/**
	 * 对象转xml
	 * @param value
	 * @param cl
	 * @return
	 */
	public static <T> T getObjectFromXml(String value,Class<T> cl){
		return getObjectFromXml(value,cl,System.getProperty("file.encoding"),false);
	}

	public static <T> T getObjectFromXml(InputStream value,Class<T> cl){
		return getObjectFromXml(value,cl,System.getProperty("file.encoding"),false);
	}

	/**
	 * 对象转xml
	 * @param value
	 * @param cl
	 * @param encoding
	 * @return
	 */
	@SuppressWarnings({ "unchecked"})
	public static <T> T getObjectFromXml(InputStream value,Class<T> cl,String encoding,Boolean validating){
		if(value==null){
			return null;
		}
		try {
			JAXBContext context = JAXBContext.newInstance(cl);

			InputStreamReader inputStreamReader = new InputStreamReader(value,encoding);

			Unmarshaller um = context.createUnmarshaller();
			if(!validating){
				um.setSchema(null);
			}
			return (T)um.unmarshal(inputStreamReader);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "unchecked"})
	public static <T> T getObjectFromXml(String value,Class<T> cl,String encoding,Boolean validating){
		if(!StringUtils.hasText(value)){
			return null;
		}
		try {
			JAXBContext context = JAXBContext.newInstance(cl);

			ByteArrayInputStream fr = new ByteArrayInputStream(value.getBytes());

			InputStreamReader inputStreamReader = new InputStreamReader(fr,encoding);

			Unmarshaller um = context.createUnmarshaller();
			if(!validating){
				um.setSchema(null);
			}
			return (T)um.unmarshal(inputStreamReader);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
}

