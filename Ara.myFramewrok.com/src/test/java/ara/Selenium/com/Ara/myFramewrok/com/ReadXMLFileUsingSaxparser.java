package ara.Selenium.com.Ara.myFramewrok.com;

import java.io.File;
import java.util.ArrayList;
import java.util.jar.Attributes;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;

public class ReadXMLFileUsingSaxparser {
	

	
	public static void main(String args[]) throws DocumentException {
	
	

  



		File inputFile = new File(System.getProperty("user.dir") +"\\src\\main\\java\\com\\amazon\\qa\\Configuration\\PostmanResponse.xml");									
	    SAXReader saxReader = new SAXReader();					
	    Document document = saxReader.read(inputFile);							
	    String prefix = document.selectSingleNode("//name/*").getText();
	    System.out.println("Select first node:"+prefix);
	    
	    java.util.List nodes = document.selectNodes("//name/*");
	    
	    for(int i=0;i<nodes.size();i++) {
	    	System.out.println(((Node) nodes.get(i)).getText());
		    	
	    }
	    System.out.println(nodes);
	    /*String parent = document.getParent().getText();
	    System.out.println(parent);*/
	    System.out.println("Root element :" + document.getRootElement().getName());
	    
	   // attributes.getValue(i);
	   /* Document doc=document.selectSingleNode("//data").getDocument();
	    System.out.println(doc);
	    
	    
	   // the text from all the child Text and Element nodes appendedtogether.
	    String stringvalue=document.getStringValue();
	    System.out.println("*******"+stringvalue);*/
	    
	    String doc2=document.selectSingleNode("//user").getText();
	   
	

	 
	}

}
