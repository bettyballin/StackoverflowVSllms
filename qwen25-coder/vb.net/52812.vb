Dim inputText As String = txtProductID.Text.Trim()\nConsole.WriteLine("Input Text: '" & inputText & "'")\n\nIf IsNumeric(inputText) Then\n   ' ... do stuff\nElse\n   Dim msg As String = "Error! Input Text is not numeric: '" & inputText & "'"\n   Console.WriteLine(msg)\nEnd If