package TestPack;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DocumentGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
		File fxmlFile=new File("/Users/prasad/staff.xml");	
		DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
		
			Document doc=dBuilder.parse(fxmlFile);
			
			
			doc.getDocumentElement().normalize();
			
			System.out.println("Root Element :"+doc.getDocumentElement().getNodeName());
			
			NodeList nList=doc.getElementsByTagName("staff");
			
			System.out.println("-------------------------------------------------");
			
			for (int temp=0; temp < nList.getLength(); temp++){
				Node nNode=nList.item(temp);
				System.out.println("\n current element:"+nNode.getNodeName());
				
				if(nNode.getNodeType()==Node.ENTITY_NODE){
					Element eElement =(Element) nNode;
					
					System.out.println("Staff id :"+eElement.getAttribute("id"));
					System.out.println("First name :"+eElement.getElementsByTagName("firstname").item(0).getTextContent());
					
					
					
				}
			}
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
