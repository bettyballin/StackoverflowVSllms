Dim btnedit As New ImageButton\nbtnedit.CommandArgument = e.Row.Cells(0).Text ' or whatever value you want to pass\nAddHandler btnedit.Click, AddressOf btnedit_Click