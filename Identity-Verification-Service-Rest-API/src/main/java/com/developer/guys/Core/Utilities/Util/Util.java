package com.developer.guys.Core.Utilities.Util;

import com.developer.guys.Entities.Person;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;

public class Util {

    public static void sendMessage(Person person){
        try
        {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            String url = "https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx?op=TCKimlikNoDogrula";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(person), url);


            // Process the SOAP Response
            printSOAPResponse(soapResponse);

            soapConnection.close();
        }
        catch(Exception e)
        {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
        }
    }



    private static SOAPMessage createSOAPRequest(Person person) throws Exception
    {
        SOAPMessage message = MessageFactory.newInstance().createMessage();
        SOAPPart soapPart = message.getSOAPPart();

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
        envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");


        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("TCKimlikNoDogrula", "", "http://tckimlik.nvi.gov.tr/WS");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("TCKimlikNo");
        soapBodyElem1.addTextNode(String.valueOf(person.getTC()));
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("Ad");
        soapBodyElem2.addTextNode(person.getName());
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("Soyad");
        soapBodyElem3.addTextNode(person.getSurname());
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("DogumYili");
        soapBodyElem4.addTextNode(String.valueOf(person.getBirthYear()));

        MimeHeaders headers = message.getMimeHeaders();
        headers.addHeader("SOAPAction", "http://tckimlik.nvi.gov.tr/WS/TCKimlikNoDogrula");

        message.saveChanges();

        /* Print the request message */
//        System.out.print("Request SOAP Message = ");
//        message.writeTo(System.out);
//        System.out.println();

        return message;
    }

    /**
     * Method used to print the SOAP Response
     */
    private static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        MimeHeaders header = new MimeHeaders();
        header.addHeader("Content-Type", "text/xml");
        MessageFactory mf = MessageFactory.newInstance();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        StreamResult result = new StreamResult(System.out);
        StringWriter stringResult = new StringWriter();
        TransformerFactory.newInstance().newTransformer().transform(sourceContent, new StreamResult(stringResult));
        String message = stringResult.toString();
        InputStream is = new ByteArrayInputStream(message.getBytes());
        // create the SOAPMessage
        SOAPMessage soapMessage = mf.createMessage(header,is);
        // get the body
        SOAPBody soapBody = soapMessage.getSOAPBody();
        // find your node based on tag name
        NodeList nodes = soapBody.getElementsByTagName("TCKimlikNoDogrulaResult");
        // check if the node exists and get the value
        String someMsgContent = null;
        Node node = nodes.item(0);
        someMsgContent = node != null ? node.getTextContent() : "";
        System.out.println(someMsgContent);
    }
}
