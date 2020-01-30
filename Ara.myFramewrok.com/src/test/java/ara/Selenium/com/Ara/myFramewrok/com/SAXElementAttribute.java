package ara.Selenium.com.Ara.myFramewrok.com;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXElementAttribute {
    public static void main(String[] args) {
        SAXElementAttribute demo = new SAXElementAttribute();
        demo.run();
    }

    private void run() {
    	try {
    		 SAXParserFactory factory = SAXParserFactory.newInstance();
    		    SAXParser parser = factory.newSAXParser();
    		    SAXHandler handler = new SAXHandler();
    		    parser.parse("C:\\Users\\ap82\\git\\Amazon_framework\\Ara.myFramewrok.com\\src\\main\\java\\com\\amazon\\qa\\Configuration\\PostmanResponse.xml", handler);
    		  }
     catch (Exception e) {
        e.printStackTrace();
    }
    	}
    }

    class SAXHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName,
                                 String qName, Attributes attributes)
                throws SAXException {

            int attributeLength = attributes.getLength();
            System.out.println(attributeLength);
            
            
           if(attributeLength!=0) {
        	   
            if ("user".equals(qName)) {
            	
                 String attrVal = attributes.getValue("id");
                 System.out.print( attrVal );
                 System.out.println("");
                 String attrVal2 = attributes.getValue("password");
                 System.out.print( attrVal2 );
                 System.out.println("");
                 
                 SAXReader saxReader = new SAXReader();
                 File inputFile = new File(System.getProperty("user.dir") +"\\src\\main\\java\\com\\amazon\\qa\\Configuration\\PostmanResponse.xml");
                 Document document;
				try {
					document = saxReader.read(inputFile);
					 java.util.List nodes = document.selectNodes("//name/*");
		         	    
		         	    for(int i=0;i<nodes.size();i++) {
		         	    	System.out.println(((Node) nodes.get(i)).getText());
		         		    	
		         	    }
		         	    System.out.println(nodes);
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                 
            }
           
        
           } 
    }
    }
    
    
