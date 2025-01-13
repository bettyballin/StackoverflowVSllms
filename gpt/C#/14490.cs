using System;\nusing System.Net;\nusing System.Xml;\n\nclass Program\n{\n    static void Main()\n    {\n        // Replace with the URL of your SharePoint site and the list name\n        string siteUrl = "http://yoursharepointsite";\n        string listName = "YourListName";\n\n        // Set up the Lists web service\n        Lists.Lists listService = new Lists.Lists();\n        listService.Url = siteUrl + "/_vti_bin/Lists.asmx";\n        listService.Credentials = CredentialCache.DefaultCredentials;\n\n        // Create the CAML query to insert a new item\n        XmlDocument doc = new XmlDocument();\n        XmlElement batchElement = doc.CreateElement("Batch");\n        batchElement.SetAttribute("OnError", "Continue");\n        batchElement.SetAttribute("ListVersion", "1");\n        batchElement.SetAttribute("ViewName", "");\n\n        // Create the method element to specify the operation (New)\n        XmlElement methodElement = doc.CreateElement("Method");\n        methodElement.SetAttribute("ID", "1");\n        methodElement.SetAttribute("Cmd", "New");\n\n        // Define the fields and values for the new item\n        methodElement.InnerXml = \n            "<Field Name='Title'>Sample Title</Field>" + // Text field\n            "<Field Name='Field1'>Sample Text 1</Field>" + // Text field\n            "<Field Name='ChoiceField'>Choice1</Field>"; // Choice field\n\n        batchElement.AppendChild(methodElement);\n\n        // Create an XmlNode from the batch element\n        XmlNode batchNode = doc.ImportNode(batchElement, true);\n\n        // Call the UpdateListItems method to insert the new item\n        XmlNode resultNode = listService.UpdateListItems(listName, batchNode);\n\n        // Output the result\n        Console.WriteLine(resultNode.OuterXml);\n    }\n}