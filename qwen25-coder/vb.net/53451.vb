Dim conn As New ADODB.Connection\nDim rs As New ADODB.Recordset\n\n' Open the connection and specify your DSN, username, etc.\nconn.Open "your_connection_string"\n\n' Open the recordset directly on the Elements table with a filter condition\nrs.Open "SELECT * FROM Elements WHERE IdGroup = your_idGroup AND ElementID = your_ElementID", conn, adOpenDynamic, adLockOptimistic\n\nIf Not rs.EOF Then\n    ' Delete the current row\n    rs.Delete\n    rs.Update\nEnd If\n\n' Close resources\nrs.Close\nSet rs = Nothing\nconn.Close\nSet conn = Nothing