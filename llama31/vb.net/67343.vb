Dim xnl As XmlNodeList = xDoc.SelectNodes(xp.ToString())\nDim returnXDoc As New XmlDocument(xDoc.NameTable)\nreturnXDoc.LoadXml("<root/>") ' create a new XmlDocument with a root node\nreturnXDoc.DocumentElement.InnerXml = xnl.Cast(Of XmlNode)().Select(Function(n) n.OuterXml).Join("")