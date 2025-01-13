using System.Data;\nusing System.IO;\nusing System.Xml;\n\npublic void ConvertXmlDocToDataTable(XmlDocument xmlAPDP, ref DataTable dtAPDP)\n{\n    using (StringReader stringReader = new StringReader(xmlAPDP.OuterXml))\n    {\n        using (XmlReader xmlReader = XmlReader.Create(stringReader))\n        {\n            DataSet dsAPDP = new DataSet();\n            dsAPDP.ReadXml(xmlReader);\n\n            // Assuming you are interested in the first table of the dataset\n            if (dsAPDP.Tables.Count > 0)\n            {\n                dtAPDP = dsAPDP.Tables[0];\n            }\n        }\n    }\n}