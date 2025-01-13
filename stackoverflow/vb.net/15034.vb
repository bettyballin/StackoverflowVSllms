Public Function MakeSQLSafe(ByVal sql As String) As String\n    'first i'd avoid putting quote chars in as they might be valid? just double them up.\n    Dim strIllegalChars As String = "/?-^%{}[];$=*`#|&@\<>()+,\"\n    'replace single quotes with double so they don't cause escape character\n    If sql.Contains("'") Then\n        sql = sql.Replace("'", "''")\n    End If\n    'need to double up double quotes from what I remember to get them through\n    If sql.Contains("""") Then\n        sql = sql.Replace("""", """""")\n    End If\n    'remove illegal chars\n    For Each c As Char In strIllegalChars\n        If sql.Contains(c.ToString) Then\n            sql = sql.Replace(c.ToString, "")\n        End If\n    Next\n\n    Return sql\nEnd Functio