Public Class ExampleClass\n    Public Sub PrintTypeName()\n        Dim typeName As Type = GetType(Me)\n        Console.WriteLine("The type of this instance is: " & typeName.Name)\n    End Sub\nEnd Class\n\nModule Module1\n    Sub Main()\n        Dim obj As New ExampleClass()\n        obj.PrintTypeName()\n    End Sub\nEnd Module