objBooks = objDoc.SelectSingleNode("//books")\n\nDim pos As Integer = 1\nFor Each book As XmlNode In objBooks.ChildNodes\n\n   Console.Write(pos & " ")\n\n   pos = pos + 1\nNext