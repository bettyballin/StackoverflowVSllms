Public Class Person\n  Public Property Name As String\n  Public Property Age As Integer\nEnd Class\n\nModule Module1\n    Sub Main()\n        Dim p As New Person With {.Name = "James", .Age = 100}\n\n        ' Create an anonymous type with properties from 'p' and a new property\n        Dim n = New With {Key .Name = p.Name, Key .Age = p.Age, .ShoeSize = 10}\n\n        ' Output the values to verify\n        Console.WriteLine($"Name: {n.Name}, Age: {n.Age}, ShoeSize: {n.ShoeSize}")\n    End Sub\nEnd Module