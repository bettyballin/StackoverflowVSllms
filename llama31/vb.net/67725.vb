Dim rsElements As New ADODB.Recordset\nDim strSQL As String\n\nstrSQL = "SELECT * FROM Elements WHERE IdGroup = " & lngIdGroup\n\nrsElements.Open strSQL, cn, adOpenStatic, adLockOptimistic\n\nIf Not rsElements.EOF Then\n    rsElements.Delete adAffectCurrent\n    rsElements.Update\nEnd If\n\nrsElements.Close