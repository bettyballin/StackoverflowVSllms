Protected Sub GridView1_SelectedIndexChanged(sender As Object, e As EventArgs) Handles GridView1.SelectedIndexChanged\n    ' Handle the selection\n    Dim selectedRowIndex As Integer = GridView1.SelectedIndex\n    Dim selectedRow As GridViewRow = GridView1.Rows(selectedRowIndex)\n    ' your code to process selected row\nEnd Sub