Private Sub Form_Load()\n       ' Example of setting a text box with the top salesperson\n       Dim rst As DAO.Recordset\n       Set rst = CurrentDb.OpenRecordset("SELECT TOP 1 Salesperson FROM SalesTable ORDER BY TotalSales DESC;")\n       \n       If Not rst.EOF Then\n           Me.txtTopSalesperson.Value = rst!Salesperson\n       End If\n       \n       rst.Close\n       Set rst = Nothing\n   End Sub