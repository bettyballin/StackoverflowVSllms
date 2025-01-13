Imports System.Collections.Generic\n\nPublic Module Combinations\n    Public Function GenerateCombinations(Of T)(list As List(Of T), k As Integer) As IEnumerable(Of List(Of T))\n        If k = 0 Then\n            Return {New List(Of T)}\n        ElseIf list.Count < k Then\n            Return Enumerable.Empty(Of List(Of T))()\n        Else\n            Dim first = list.First()\n            Dim rest = list.GetRange(1, list.Count - 1)\n            Return GenerateCombinations(rest, k - 1).Select(Function(c) c.Prepend(first).ToList()).Concat(GenerateCombinations(rest, k))\n        End If\n    End Function\nEnd Module