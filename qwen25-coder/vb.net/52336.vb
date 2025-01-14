' Step 1: Define a named class for the result\nPublic Class HistoryItem\n    Public Property ActionOn As DateTime\n    Public Property ActionBy As String\n    Public Property Description As String\n    Public Property ImpactedItem As String\n    Public Property ActionDescription As String\nEnd Class\n\n' Step 2: Modify your function to use the named class\nPublic Function GetHistory(ByVal historyId As Integer) As List(Of HistoryItem)\n    Using dc As New myDataContext(Application.GetConnection())\n        Return (From t In dc.ActionTypes, a In t.MyTable \n                Where a.HistoryID = historyId \n                Select New HistoryItem With {\n                    .ActionOn = a.ActionOn,\n                    .ActionBy = a.ActionBy,\n                    .Description = t.Description,\n                    .ImpactedItem = a.ImpactedItem,\n                    .ActionDescription = a.ActionDescription\n                }).ToList()\n    End Using\nEnd Functio