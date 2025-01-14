Function ExtractTextFromHTML(html As String) As String\n    Dim startPos As Integer\n    Dim endPos As Integer\n    Dim textContent As String\n    Dim tagStart As String\n    Dim tagEnd As String\n    \n    ' Initialize the position and content variables\n    startPos = 1\n    endPos = 1\n    textContent = ""\n    \n    ' Loop through the HTML to find text between tags\n    Do While startPos < Len(html)\n        ' Find the start of a tag\n        startPos = InStr(startPos, html, "<")\n        \n        ' Extract any text before this tag\n        If startPos > endPos Then\n            textContent = textContent & Mid$(html, endPos, startPos - endPos)\n        End If\n        \n        ' Find the end of the current tag\n        endPos = InStr(startPos, html, ">")\n        \n        ' Update the start position to just after this tag\n        If endPos > 0 Then\n            startPos = endPos + 1\n        Else\n            Exit Do ' No more tags found\n        End If\n    Loop\n    \n    ExtractTextFromHTML = textContent\nEnd Function\n\nSub TestExtractText()\n    Dim html As String\n    Dim plainText As String\n    \n    ' Example HTML content\n    html = "<html><body><h1>Header</h1><p>This is a <strong>sample</strong> paragraph.</p></body></html>"\n    \n    ' Extract text from the HTML\n    plainText = ExtractTextFromHTML(html)\n    \n    ' Display the extracted text\n    MsgBox "Extracted Text: " & vbCrLf & plainText\nEnd Sub