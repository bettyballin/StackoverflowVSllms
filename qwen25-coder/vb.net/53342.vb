Dim xml As String = "<xml><author>Joe the Magnificent</author><title>Joe Goes Home</title></xml>"\nDim author As String\nDim title As String\n\nTry\n    Dim xDoc As New XmlDocument\n    xDoc.LoadXml(xml)\n\n    ' Accessing elements safely\n    Dim xAuthorNodes As XmlNodeList = xDoc.GetElementsByTagName("author")\n    If xAuthorNodes.Count > 0 Then\n        author = xAuthorNodes(0).InnerText\n    End If\n\n    Dim xTitleNodes As XmlNodeList = xDoc.GetElementsByTagName("title")\n    If xTitleNodes.Count > 0 Then\n        title = xTitleNodes(0).InnerText\n    End If\n\n    ShowMessage(author, title)\n\nCatch ex As Exception\n    ' Handle exceptions here\n    Console.WriteLine("Error parsing XML: " & ex.Message)\nEnd Try