@XmlSchema(
    elementFormDefault = XmlNsForm.QUALIFIED,
    xmlns = {
        @XmlNs(prefix = "a", namespaceURI = "urn:my:ns2"),
        @XmlNs(prefix = "b", namespaceURI = "urn:my:ns3")
    },
    namespace = "urn:my:ns1"
)
package com.example.myapp;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;

public class PackageInfoAnnotationassistantThisisthenameofatypicalclassinJavathatholdspackagelevelannotations {
    public static void main(String[] args) {
    }
}