XmlNode node = xmlDocument.SelectSingleNode(\n    String.Format("//ErrorTable[ProjectName/text()='{0}']", projectName));\n\nif (node != null)\n{\n    // Node exists\n}\nelse\n{\n    // Node does not exist\n}