Dim mainString As String = "Hello, World!"\nDim subString As String = "World"\nDim position As Integer = FindSubstring(mainString, subString)\n\nIf position <> -1 Then\n    Console.WriteLine("Substring found at position: " & position)\nElse\n    Console.WriteLine("Substring not found.")\nEnd If