Imports System.Reflection\n\nPublic Class objLocation\n    Public SysLocationId As String\n    Public NameFull As String\n    Public LatRaw As String\n    Public LongRaw As String\n    Public Active As Integer\n\n    ' Method to get property value by index\n    Public Function GetPropertyByIndex(index As Integer) As Object\n        Dim properties As PropertyInfo() = Me.GetType().GetFields(BindingFlags.Public Or BindingFlags.Instance)\n        If index >= 0 AndAlso index < properties.Length Then\n            Return properties(index).GetValue(Me)\n        Else\n            Throw New IndexOutOfRangeException("Index out of range.")\n        End If\n    End Function\nEnd Class\n\nModule Module1\n    Sub Main()\n        Dim lLocation As New objLocation()\n        lLocation.SysLocationId = "123"\n        lLocation.NameFull = "Full Name"\n        lLocation.LatRaw = "12.3456"\n        lLocation.LongRaw = "65.4321"\n        lLocation.Active = 1\n\n        ' Access properties by index\n        For i As Integer = 0 To 4\n            Console.WriteLine(lLocation.GetPropertyByIndex(i))\n        Next\n    End Sub\nEnd Module