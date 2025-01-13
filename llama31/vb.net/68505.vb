Dim xmlDoc, xmlNodes, xmlNode, au_id, au_fname, au_lname, title\n\n' Load the XML document\nSet xmlDoc = CreateObject("MSXML2.DOMDocument")\nxmlDoc.LoadXML "<Root><Authors au_id=""409-56-7008"" au_lname=""Bennet"" au_fname=""Abraham""><Titles title=""The Busy Executive's Database Guide""/></Authors><Authors au_id=""648-92-1872"" au_lname=""Blotchet-Halls"" au_fname=""Reginald""><Titles title=""Fifty Years in Buckingham Palace Kitchens""/></Authors><Authors au_id=""238-95-7766"" au_lname=""Carson"" au_fname=""Cheryl""><Titles title=""But Is It User Friendly""/></Authors><Authors au_id=""722-51-5454"" au_lname=""DeFrance"" au_fname=""Michel""><Titles title=""The Gourmet Microwave""/></Authors><Authors au_id=""712-45-1867"" au_lname=""del Castillo"" au_fname=""Innes""><Titles title=""Silicon Valley Gastronomic Treats""/></Authors><Authors au_id=""427-17-2319"" au_lname=""Dull"" au_fname=""Ann""><Titles title=""Secrets of Silicon Valley""/></Authors><Authors au_id=""267-41-2394"" au_lname=""Ellis"" au_fname=""Michael""><Titles title=""Cooking with Computers: Surreptitious Balance Sheets""/><Titles title=""Sushi for Anyone""/></Authors><Authors au_id=""213-46-8915"" au_lname=""Green"" au_fname=""Marjorie""><Titles title=""The Busy Executive's Database Guide""/><Titles title=""You Can Combat Computer Stress""/></Authors></Root>"\n\n' Get the Authors nodes\nSet xmlNodes = xmlDoc.SelectNodes("/Root/Authors")\n\n' Loop through each Authors node\nFor Each xmlNode In xmlNodes\n    ' Get the au_id, au_fname, and au_lname attributes\n    au_id = xmlNode.Attributes.GetNamedItem("au_id").Value\n    au_fname = xmlNode.Attributes.GetNamedItem("au_fname").Value\n    au_lname = xmlNode.Attributes.GetNamedItem("au_lname").Value\n    \n    ' Get the first Titles node\n    Set titleNode = xmlNode.SelectSingleNode("Titles[1]")\n    If Not titleNode Is Nothing Then\n        title = titleNode.Attributes.GetNamedItem("title").Value\n    Else\n        title = ""\n    End If\n    \n    ' Print the values\n    Response.Write au_id & ", " & au_fname & ", " & au_lname & ", " & title & "<br>"\nNext\n\n' Clean up\nSet xmlDoc = Nothing\nSet xmlNodes = Nothing\nSet xmlNode = Nothing