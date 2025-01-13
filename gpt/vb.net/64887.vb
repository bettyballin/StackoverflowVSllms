Imports System.Reflection\n\nPublic Class Parent\n    Private _child As ChildObject()\n    Public Property Child As ChildObject()\n        Get\n            Return _child\n        End Get\n        Set(ByVal value As ChildObject())\n            _child = value\n        End Set\n    End Property\nEnd Class\n\nPublic Class ChildObject\n    Private _name As String\n    Public Property Name As String\n        Get\n            Return _name\n        End Get\n        Set(ByVal value As String)\n            _name = value\n        End Set\n    End Property\n\n    Private _descr As String\n    Public Property Descr As String\n        Get\n            Return _descr\n        End Get\n        Set(ByVal value As String)\n            _descr = value\n        End Set\n    End Property\nEnd Class\n\nModule Module1\n    Sub Main()\n        Dim Results() As String = {"1,2", "2,3"}\n        Dim parent As New Parent()\n\n        Dim childArray(Results.Length - 1) As ChildObject\n        For i As Integer = 0 To Results.Length - 1\n            Dim child As New ChildObject()\n            Dim ResultSet As String() = Results(i).Split(",")\n\n            Dim PropInfo As PropertyInfo() = child.GetType().GetProperties()\n            For j As Integer = 0 To ResultSet.Length - 1\n                PropInfo(j).SetValue(child, ResultSet(j))\n            Next\n\n            childArray(i) = child\n        Next\n\n        ' Assign the child array to the parent object using reflection\n        Dim parentType As Type = parent.GetType()\n        Dim childProperty As PropertyInfo = parentType.GetProperty("Child")\n        childProperty.SetValue(parent, childArray)\n\n        ' Verify the assignment\n        For Each child In parent.Child\n            Console.WriteLine($"Name: {child.Name}, Descr: {child.Descr}")\n        Next\n\n        Console.ReadLine()\n    End Sub\nEnd Module