Dim cn As ADODB.Connection\nDim rs As ADODB.Recordset \n\nstrFile = Workbooks(1).FullName\nstrCon = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=" & strFile _\n    & ";Extended Properties=""Excel 8.0;HDR=Yes;IMEX=1"";"\n\nSet cn = CreateObject("ADODB.Connection")\nSet rs = CreateObject("ADODB.Recordset")\n\ncn.Open strCon\n\n''Pick one:\nstrSQL = "SELECT * FROM DataTable" ''Named range\nstrSQL = "SELECT * FROM [Sheet1$A1:E346]" ''Range\n\nrs.Open strSQL, cn\n\nDebug.Print rs.GetString