Private Const MAX_SELECTIONS As Integer = 3\n\nProtected Sub ListBox1_SelectedIndexChanged(sender As Object, e As EventArgs) Handles ListBox1.SelectedIndexChanged\n    ' Check how many items are currently selected\n    Dim selectedCount As Integer = ListBox1.Items.Cast(Of ListItem)().Count(Function(item) item.Selected)\n\n    If selectedCount > MAX_SELECTIONS Then\n        ' Too many items selected; deselect the newly selected one\n        Dim newlySelectedIndex As Integer = ListBox1.SelectedIndex\n        Dim newlySelectedItem As ListItem = ListBox1.Items(newlySelectedIndex)\n\n        newlySelectedItem.Selected = False\n\n        ' Optionally inform the user or take other actions\n    End If\nEnd Sub