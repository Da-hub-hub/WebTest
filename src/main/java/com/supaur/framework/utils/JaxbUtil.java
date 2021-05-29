package com.supaur.framework.utils;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

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
}

