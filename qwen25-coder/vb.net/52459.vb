Public Class Cart\n\n    Private sItems As String\n\n    Public Function addItem(ByVal itemName As String) As Cart\n        sItems = sItems + "|" + itemName + "|"\n        Return Me\n    End Function\n\nEnd Class