Imports System.IO\n\nModule Module1\n    Sub Main()\n        ' Read all lines from a text file\n        Dim fileContents As String = My.Computer.FileSystem.ReadAllText("C:\example.txt")\n        Console.WriteLine(fileContents)\n    End Sub\nEnd Module