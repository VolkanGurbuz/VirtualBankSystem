package com.developer.guys.Core.Utilities.Util;

import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

public class Util {

    public static void sendMessage(){
        try
        {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            String url = "https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx?op=TCKimlikNoDogrula";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);


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



    private static SOAPMessage createSOAPRequest() throws Exception
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
        soapBodyElem1.addTextNode("242534546");
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("Ad");
        soapBodyElem2.addTextNode("SELAMI");
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("Soyad");
        soapBodyElem3.addTextNode("SAHIN");
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("DogumYili");
        soapBodyElem4.addTextNode("1990");

        MimeHeaders headers = message.getMimeHeaders();
        headers.addHeader("SOAPAction", "http://tckimlik.nvi.gov.tr/WS/TCKimlikNoDogrula");

        message.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        message.writeTo(System.out);
        System.out.println();

        return message;
    }

    /**
     * Method used to print the SOAP Response
     */
    private static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        System.out.print("\nResponse SOAP Message = ");
        StreamResult result = new StreamResult(System.out);
        transformer.transform(sourceContent, result);
    }



}
