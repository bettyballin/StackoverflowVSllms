For i As Integer = 0 To GridView1.Rows.Count - 1\n    btnedit.ImageUrl = "\images\bttnEditMini.gif"\n    btndelete.ToolTip = "Deletes the Current Record"\n    btnedit.ToolTip = "Edits the Current Record"\n    btndelete.ImageUrl = "\images\bttnDeleteMini.gif"\n    \n    ' Add edit button\n    GridView1.Rows(i).Cells(4).Controls.Add(btnedit)\n    \n    ' Add a space between buttons\n    GridView1.Rows(i).Cells(4).Controls.Add(New LiteralControl("&nbsp;"))\n    \n    ' Add delete button\n    GridView1.Rows(i).Cells(4).Controls.Add(btndelete)\nNext