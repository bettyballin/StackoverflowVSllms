XmlNode listTemplateCollection = lists.GetListTemplateCollection();\n\nforeach (XmlNode template in listTemplateCollection.SelectNodes("ListTemplate"))\n{\n    Console.WriteLine(template.Attributes["Name"].Value);\n}