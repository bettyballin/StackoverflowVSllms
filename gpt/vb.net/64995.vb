'Using Generics\nPublic Class GenericList(Of T)\n    Private items As New List(Of T)\n\n    Public Sub Add(item As T)\n        items.Add(item)\n    End Sub\n\n    Public Function GetItem(index As Integer) As T\n        Return items(index)\n    End Function\nEnd Class\n\n'Using Nullable Types\nDim nullableInt As Integer? = Nothing\nIf nullableInt.HasValue Then\n    Console.WriteLine("Value: " & nullableInt.Value)\nElse\n    Console.WriteLine("No value")\nEnd If