Public Class GenericCollection(Of T)\n    Private items As List(Of T)\n\n    Public Sub New()\n        items = New List(Of T)()\n    End Sub\n\n    Public Sub Add(item As T)\n        items.Add(item)\n    End Sub\n\n    Public Function Item(index As Integer) As T\n        Return items(index)\n    End Function\n\n    Public ReadOnly Property Count() As Integer\n        Get\n            Return items.Count\n        End Get\n    End Property\nEnd Class