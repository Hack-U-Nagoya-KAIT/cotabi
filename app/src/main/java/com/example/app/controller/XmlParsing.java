package com.example.app.controller;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

class YolpData {
    String name;
    double lat;
    double lon;

    public YolpData(String name, double lat, double lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }
}

public class XmlParsing {
    public static void xml(String... xmlDataArray) {
        List<YolpData> dataList = new ArrayList<>();
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

                        Element CoordinatesElement = (Element) CoordinatesNodeList.item(0);
                        String coordinates = CoordinatesElement.getTextContent();

                        // Coordinatesを分割してlatとlonを取得
                        String[] coordParts = coordinates.split(",");
                        double lat = Double.parseDouble(coordParts[1]);
                        double lon = Double.parseDouble(coordParts[0]);

                        // YolpDataオブジェクトを作成してリストに追加
                        YolpData data = new YolpData(name, lat, lon);
                        dataList.add(data);

                        System.out.println("Name: " + name);
                        System.out.println("座標: " + coordinates);
                        System.out.println("lat: " + lat);
                        System.out.println("lon: " + lon);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // dataListの内容を表示
        for (YolpData data : dataList) {
            System.out.println("Name: " + data.name);
            System.out.println("lat: " + data.lat);
            System.out.println("lon: " + data.lon);
        }
        ChatGptService.sendChatGptRequest(dataList);
    }
}