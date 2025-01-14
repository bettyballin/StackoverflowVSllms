Public Class LazyList(Of T)\n    Implements IEnumerable(Of T)\n    Implements IList(Of T)\n\n    Private Inner As List(Of T)\n\n    Public Sub New(inner As List(Of T))\n        Me.Inner = inner\n    End Sub\n\n    ' Explicitly implement the IEnumerable(Of T) GetEnumerator method.\n    Private Function IEnumerable_GetEnumerator() As IEnumerator(Of T) Implements IEnumerable(Of T).GetEnumerator\n        Return Inner.GetEnumerator()\n    End Function\n\n    ' Explicitly implement the IEnumerable GetEnumerator method.\n    Private Function IEnumerable_NonGeneric_GetEnumerator() As IEnumerator Implements IEnumerable.GetEnumerator\n        Return DirectCast(Inner, IEnumerable).GetEnumerator()\n    End Function\n\n    ' Other IList(Of T) methods and properties must also be implemented here.\nEnd Class