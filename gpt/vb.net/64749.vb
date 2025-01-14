<%\nDim xmlDoc\nDim authors\nDim author\nDim title\n\n' Create an instance of the MSXML2.DOMDocument object\nSet xmlDoc = Server.CreateObject("MSXML2.DOMDocument.6.0")\n\n' Load the XML data\nxmlDoc.async = False\nxmlDoc.loadXML "<Root><Authors au_id='409-56-7008' au_lname='Bennet' au_fname='Abraham'><Titles title='The Busy Executive&apos;s Database Guide'/></Authors><Authors au_id='648-92-1872' au_lname='Blotchet-Halls' au_fname='Reginald'><Titles title='Fifty Years in Buckingham Palace Kitchens'/></Authors><Authors au_id='238-95-7766' au_lname='Carson' au_fname='Cheryl'><Titles title='But Is It User Friendly'/></Authors><Authors au_id='722-51-5454' au_lname='DeFrance' au_fname='Michel'><Titles title='The Gourmet Microwave'/></Authors><Authors au_id='712-45-1867' au_lname='del Castillo' au_fname='Innes'><Titles title='Silicon Valley Gastronomic Treats'/></Authors><Authors au_id='427-17-2319' au_lname='Dull' au_fname='Ann'><Titles title='Secrets of Silicon Valley'/></Authors><Authors au_id='267-41-2394' au_lname='Ellis' au_fname='Michael'><Titles title='Cooking with Computers: Surreptitious Balance Sheets'/><Titles title='Sushi for Anyone'/></Authors><Authors au_id='213-46-8915' au_lname='Green' au_fname='Marjorie'><Titles title='The Busy Executive&apos;s Database Guide'/><Titles title='You Can Combat Computer Stress'/></Authors></Root>"\n\n' Check if the XML is loaded successfully\nIf xmlDoc.parseError.errorCode <> 0 Then\n    Response.Write "Error loading XML: " & xmlDoc.parseError.reason\nElse\n    ' Select the authors nodes\n    Set authors = xmlDoc.selectNodes("/Root/Authors")\n\n    ' Iterate through each author node\n    For Each author in authors\n        Dim au_id\n        Dim au_fname\n        Dim au_lname\n        Dim Titles\n\n        ' Get author details\n        au_id = author.getAttribute("au_id")\n        au_fname = author.getAttribute("au_fname")\n        au_lname = author.getAttribute("au_lname")\n        \n        ' Select the first title node\n        Set title = author.selectSingleNode("Titles/@title")\n        \n        If Not title Is Nothing Then\n            Titles = title.text\n        Else\n            Titles = ""\n        End If\n\n        ' Output the results\n        Response.Write "Author ID: " & au_id & "<br>"\n        Response.Write "First Name: " & au_fname & "<br>"\n        Response.Write "Last Name: " & au_lname & "<br>"\n        Response.Write "Title: " & Titles & "<br><br>"\n    Next\nEnd If\n\n' Clean up\nSet title = Nothing\nSet author = Nothing\nSet authors = Nothing\nSet xmlDoc = Nothing\n%>