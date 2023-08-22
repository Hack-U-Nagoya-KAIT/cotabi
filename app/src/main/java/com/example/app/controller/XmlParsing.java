package com.example.app.controller;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlParsing {
    public static void xml(String... xmlDataArray) {
        for (String xmlData : xmlDataArray) {

            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(new InputSource(new StringReader(xmlData)));

                document.getDocumentElement().normalize();

                NodeList nodeList = document.getElementsByTagName("Feature");

                System.out.println(nodeList.getLength());

                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);

                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element featureElement = (Element) node;

                        NodeList nameNodeList = featureElement.getElementsByTagName("Name");
                        NodeList CoordinatesNodeList = featureElement.getElementsByTagName("Coordinates");

                        Element nameElement = (Element) nameNodeList.item(0);
                        String name = nameElement.getTextContent();
                        System.out.println("Name: " + name);

                        Element CoordinatesElement = (Element) CoordinatesNodeList.item(0);
                        String coordinates = CoordinatesElement.getTextContent();
                        System.out.println("座標： " + coordinates);

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}