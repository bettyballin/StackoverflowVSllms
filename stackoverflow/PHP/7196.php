$dom = dom_import_simplexml($simpleXml)->ownerDocument;\n$dom->formatOutput = true;\necho $dom->saveXML();