Private Sub CheckBox1_Click()\n    If Me.CheckBox1.Value = True Then\n        Me.TextBox1.Enabled = True\n    Else\n        Me.TextBox1.Enabled = False\n        ' Clear the text box content or handle it as needed\n        Me.TextBox1.Value = ""\n    End If\nEnd Sub\n\nPrivate Sub CheckBox2_Click()\n    If Me.CheckBox2.Value = True Then\n        Me.TextBox2.Enabled = True\n    Else\n        Me.TextBox2.Enabled = False\n        Me.TextBox2.Value = ""\n    End If\nEnd Sub\n\nPrivate Sub CommandButtonSearch_Click()\n    Dim searchCriteria As String\n    \n    ' Start building your criteria string based on checked boxes and text entries\n    searchCriteria = "1=1" ' This is just a starting point that always evaluates to true\n    \n    If Me.CheckBox1.Value And Not IsNull(Me.TextBox1.Value) Then\n        searchCriteria = searchCriteria & " AND [Field1] LIKE '*" & Me.TextBox1.Value & "*'"\n    End If\n    \n    If Me.CheckBox2.Value And Not IsNull(Me.TextBox2.Value) Then\n        searchCriteria = searchCriteria & " AND [Field2] LIKE '*" & Me.TextBox2.Value & "*'"\n    End If\n    \n    ' Apply the criteria to a RecordSource or filter of your form\n    Me.Filter = searchCriteria\n    Me.FilterOn = True\nEnd Sub