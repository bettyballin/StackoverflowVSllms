Dim nonBreakingSpace As String = ChrW(160)\nDim xmlContent As XElement = <root>This is some text followed by a non-breaking space: <%= nonBreakingSpace %> and more text.</root>\n\nConsole.WriteLine(xmlContent)