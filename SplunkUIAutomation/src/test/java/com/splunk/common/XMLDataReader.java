
package com.splunk.common;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import java.util.ArrayList;

/**
 * @author Avneet Dhanoa
 */

public class XMLDataReader {

    String filePath = System.getProperty("user.dir") + "/src/test/resources/testData.xml";


    public String getSingleValue(String rootNode, String value) {
        // Example: getSingleValue("idahoUser", "ssn")
        // DOM Parser
        try {

            File inputFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("\nRoot element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName(rootNode);
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    //System.out.println("Value : " + eElement.getElementsByTagName(value).item(0).getTextContent());
                    value = eElement.getElementsByTagName(value).item(0).getTextContent();
                    return value;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    // }

    public ArrayList<String> getMultipleValue(String rootNode) {
        // Example: getMultipleValue("fssUser")
        ArrayList<String> list = new ArrayList<String>();
        // DOM Parser
        try {
            File inputFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName(rootNode);
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    int elementSize = eElement.getTagName().length();
                    System.out.println("elementSize : " + elementSize);
                    for (int i = 0; i <= elementSize - 1; i++) {
                        // System.out.println("User Tag: " +
                        // eElement.getElementsByTagName("user").item(i).getTextContent());
                        String user = eElement.getElementsByTagName("user").item(i).getTextContent();
                        list.add(user);
                    }

                    // System.out.println("First Name : " +
                    // eElement.getElementsByTagName("firstName").item(0).getTextContent());
                    /*
                     * System.out.println("Family Name : " +
                     * eElement.getElementsByTagName(
                     * "familyName").item(0).getTextContent());
                     * System.out.println("Date of Birth : " +
                     * eElement.getElementsByTagName("dob").item(0).getTextContent());
                     * System.out.println("City : " +
                     * eElement.getElementsByTagName("city").item(0).getTextContent());
                     * System.out.println("State : " +
                     * eElement.getElementsByTagName("state").item(0).getTextContent());
                     * System.out.println("Zipcode : " +
                     * eElement.getElementsByTagName("zip").item(0).getTextContent());
                     */

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
