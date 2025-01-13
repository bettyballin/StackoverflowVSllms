using System;\nusing System.Data;\nusing System.IO;\nusing System.Text;\n\nclass Program\n{\n    static void Main()\n    {\n        string itemsXML = @"\n            <items>\n                <item>\n                    <id>i1</id>\n                    <name>item1</name>\n                    <subitems>\n                        <subitem><name>subitem1</name></subitem>\n                        <subitem><name>subitem2</name></subitem>\n                    </subitems>\n                </item>\n                <item>\n                    <id>i2</id>\n                    <name>item2</name>\n                    <subitems>\n                        <subitem><name>subitem1</name></subitem>\n                        <subitem><name>subitem2</name></subitem>\n                    </subitems>\n                </item>\n            </items>";\n\n        StringBuilder modifiedXml = new StringBuilder(itemsXML);\n\n        // Modify the XML to have subitem as a separate tag\n        int index;\n        while((index = modifiedXml.ToString().IndexOf("<name>", StringComparison.Ordinal)) != -1)\n        {\n            modifiedXml.Replace("<name>", "<subitem><name>", 0, index);\n            index = modifiedXml.ToString().IndexOf("</name>", Math.Max(0, index - 20), StringComparison.Ordinal) + "</name>".Length;\n            modifiedXml.Replace("</name>", "</name></subitem>", 0, index);\n        }\n\n        MemoryStream itemsStream = new MemoryStream(Encoding.ASCII.GetBytes(modifiedXml.ToString()));\n        DataSet itemsSet = new DataSet();\n        itemsSet.ReadXml(itemsStream);\n\n        Console.WriteLine("Items:");\n        foreach (DataRow itemRow in itemsSet.Tables["Item"].Rows)\n        {\n            Console.WriteLine($"id={itemRow["id"]} name={itemRow["name"]}");\n            if (itemRow.HasVersion(DataRowVersion.Current) && itemsSet.Relations.Count > 0)\n            {\n                DataRow[] subitemRows = itemRow.GetChildRows(itemsSet.Relations[0]);\n                foreach (var subitemRow in subitemRows)\n                {\n                    Console.WriteLine($"subitem name={subitemRow["name"]}");\n                }\n            }\n        }\n    }\n}