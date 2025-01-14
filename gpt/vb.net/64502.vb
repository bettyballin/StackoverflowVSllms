Sub GetHTMLSource()\n    Dim xmlhttp As Object\n    Dim url As String\n    Dim htmlSource As String\n    \n    url = "http://www.example.com" ' Replace with your target URL\n    Set xmlhttp = CreateObject("MSXML2.XMLHTTP.6.0")\n\n    With xmlhttp\n        .Open "GET", url, False\n        .setRequestHeader "Content-Type", "text/html"\n        .send\n        If .Status = 200 Then\n            htmlSource = .responseText\n            Debug.Print htmlSource ' Output HTML source to Immediate Window\n        Else\n            MsgBox "Failed to retrieve the web page. Status: " & .Status\n        End If\n    End With\n\n    Set xmlhttp = Nothing\nEnd Sub