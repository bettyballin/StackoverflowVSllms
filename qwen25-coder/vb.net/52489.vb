Imports System.Reflection\n\nModule Module1\n    Sub Main()\n        Try\n            ' Accessing embedded resource\n            Dim assembly As Assembly = Assembly.GetExecutingAssembly()\n            Using streamReader As New IO.StreamReader(assembly.GetManifestResourceStream("YourNamespace.Welcome.txt"))\n                Console.WriteLine(streamReader.ReadToEnd())\n            End Using\n        Catch ex As Exception\n            ' Output exception information for debugging\n            Console.WriteLine(ex.Message)\n            Console.WriteLine(ex.StackTrace)\n        End Try\n\n        Console.ReadLine()\n    End Sub\nEnd Module