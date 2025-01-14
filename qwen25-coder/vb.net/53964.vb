Public Class Page\n\n    Private _IdList As List(Of Integer)\n    Private _HasNewItems As Boolean = False\n\n    Public Sub AddItems(ByVal Items As List(Of Item))\n\n        Dim newIds = (From item In Items Select item.ID).ToList()\n        Dim distinctCurrentIds = _IdList.Distinct().ToList()\n\n        ' Find ids that are in `newIds` but not in `_IdList`\n        Dim uniqueNewIds = newIds.Except(distinctCurrentIds)\n\n        If Not uniqueNewIds.Any() Then\n            _HasNewItems = False\n        Else\n            _HasNewItems = True\n            _IdList.AddRange(uniqueNewIds)\n        End If\n\n        ' Ensure the list remains distinct\n        _IdList = _IdList.Distinct().ToList()\n\n    End Sub\n\nEnd Class