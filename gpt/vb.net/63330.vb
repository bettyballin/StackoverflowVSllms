If dtDataTable Is Nothing OrElse dtDataTable.Rows.Count = 0 Then\n    ' No data found\n    lbl_count.Text = "Found 0 result"\nElse\n    ' Data found\n    lbl_count.Text = "Found " & dtDataTable.Rows.Count.ToString() & " results"\nEnd If