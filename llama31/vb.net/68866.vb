Private Sub ListBox1_SelectedIndexChanged(sender As Object, e As EventArgs) Handles ListBox1.SelectedIndexChanged\n    If ListBox1.SelectedItems.Count > 3 Then\n        ListBox1.SelectedItems.RemoveAt(ListBox1.SelectedItems.Count - 1)\n        MessageBox.Show("You can only select up to 3 items.")\n    End If\nEnd Sub