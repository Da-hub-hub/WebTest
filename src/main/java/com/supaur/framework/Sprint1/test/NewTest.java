package com.supaur.framework.Sprint1.test;

import com.gargoylesoftware.htmlunit.xml.XmlUtil;
import com.supaur.framework.Sprint1.entity.UiTestCase;
import com.supaur.framework.seleniumTool.DriverGet;
import com.supaur.framework.seleniumTool.ElementGet;
import com.supaur.framework.utils.MyException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.openqa.selenium.WebDriver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.*;

public class NewTest {
    public static String xmlChangeString(String fileName){
        try {
            SAXReader saxReader = new SAXReader();
            Document tempDocument = saxReader.read(XmlUtil.class.getClassLoader().getResourceAsStream(fileName));
            return tempDocument.asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static UiTestCase test(String path) throws JAXBException, ParserConfigurationException, SAXException {
        String s = NewTest.xmlChangeString(path);
        JAXBContext jaxbContext = JAXBContext.newInstance(UiTestCase.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        String xml =s;
        StringReader reader = new StringReader(xml);
        SAXParserFactory sax = SAXParserFactory.newInstance();
        sax.setNamespaceAware(false);//设置忽略明明空间
        XMLReader xmlReader = sax.newSAXParser().getXMLReader();
        Source source = new SAXSource(xmlReader, new InputSource(reader));

        UiTestCase uiTestCase = (UiTestCase) unmarshaller.unmarshal(source);
        return uiTestCase;

    }

    public static void strChangeXML(String str) throws IOException {
        SAXReader saxReader = new SAXReader();
        Document document;
        try {
            document = saxReader.read(new ByteArrayInputStream(str.getBytes("UTF-8")));
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(new FileWriter(new File("src/com/webdesk/swing/powertable/digester/cctv.xml")), format);
            writer.write(document);
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();

        }
    }

}
