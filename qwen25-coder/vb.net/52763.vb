Private Sub TextBox1_TextChanged(sender As Object, e As EventArgs) Handles TextBox1.TextChanged\n    ' Remove any non-numeric characters from the text box\n    Dim filteredText As String = New String(TextBox1.Text.Where(Function(c) Char.IsDigit(c)).ToArray())\n    If TextBox1.Text <> filteredText Then\n        TextBox1.Text = filteredText\n        TextBox1.Select(filteredText.Length, 0) ' Move the cursor to the end of the text box\n    End If\nEnd Sub