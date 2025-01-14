Module Module1\n    Sub Main(ByVal args As String())\n        If args.Length > 0 Then\n            Dim filePath As String = args(0)\n            ' Process your .eds file here.\n            ProcessDocument(filePath)\n        Else\n            ' The application is launched without a file, perhaps show the main UI\n            Application.Run(New MainForm)\n        End If\n    End Sub\n\n    Private Sub ProcessDocument(ByVal filePath As String)\n        ' Logic to open and process the document\n        Console.WriteLine("Processing file: " & filePath)\n    End Sub\nEnd Module