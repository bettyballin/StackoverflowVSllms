Imports System.Data\nImports System.Linq\n\nDim dt As DataTable = ' your datatable object\n\nDim result = From row In dt.AsEnumerable()\n             Group row By key = New With {.Dept = row.Field(Of String)("Dept"), .Code = row.Field(Of String)("Code")}\n             Into Group\n             Select New With {.Dept = key.Dept, .Code = key.Code, .Value = Group.Sum(Function(r) r.Field(Of Integer)("Value"))}\n\nDim newDt As DataTable = New DataTable()\nnewDt.Columns.Add("Dept", GetType(String))\nnewDt.Columns.Add("Code", GetType(String))\nnewDt.Columns.Add("Value", GetType(Integer))\n\nFor Each item In result\n    newDt.Rows.Add(item.Dept, item.Code, item.Value)\nNext\n\n' newDt is your new datatable with the desired output