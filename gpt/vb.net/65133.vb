Public Sub PrintNames(names() As String)\n    For Each name As String In names\n        Console.WriteLine(name)\n    Next\nEnd Sub\n\nPrintNames(New String() {"Hans", "Luke", "Lia"})