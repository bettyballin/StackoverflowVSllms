Imports System.Text.RegularExpressions\n\nModule Module1\n    Sub Main()\n        Dim input As String = "123.45 some text ???? 678.90 more text"\n        Dim pattern As String = "(\d+\.\d+)|(\?\?\?\?\?\?)"\n        Dim replacement As String = "[REPLACED]"\n\n        ' Create a Regex object with the specified pattern\n        Dim regex As New Regex(pattern)\n\n        ' Replace matched patterns in the input string\n        Dim result As String = regex.Replace(input, replacement)\n\n        Console.WriteLine(result)\n    End Sub\nEnd Module