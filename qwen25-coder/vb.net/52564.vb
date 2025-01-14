Imports HtmlAgilityPack\n\nModule Module1\n\n    Sub Main()\n        Dim htmlContent As String = "<html><body><h3>Title</h4></body></html>" ' Example HTML content from your response.\n        \n        Dim doc As New HtmlDocument()\n        doc.LoadHtml(htmlContent)\n        \n        ' Check for mismatched tags or other issues\n        For Each node In doc.DocumentNode.SelectNodes("//*/[local-name()='h3'][following-sibling::*[1][local-name()='h4']]")\n            Console.WriteLine("Mismatched tags detected: " & node.OuterHtml)\n        Next\n\n        ' You can add more checks here for different validation rules\n        \n        Console.WriteLine("Basic validation complete.")\n    End Sub\n\nEnd Module