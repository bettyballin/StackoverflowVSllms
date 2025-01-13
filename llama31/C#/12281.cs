using System.Xml.Linq;\n\n// assume 'xml' is a string containing the XML response\nXDocument doc = XDocument.Parse(xml);\n\n// use XPath to select the 'result' element\nXElement resultElement = doc.XPathSelectElement("//ns0:result", \n    new XmlNamespaceManager(new NameTable() { { "ns0", "http://dev1/MyWebService1.wsdl" } }));\n\n// get the value of the 'result' element\nstring itemNumber = resultElement.Value;\n\nConsole.WriteLine(itemNumber); // outputs "1010603"