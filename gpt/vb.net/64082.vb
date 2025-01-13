' MainForm.vb\nPublic Class MainForm\n    Private currentInputBox As TextBox\n\n    Private Sub MainForm_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load\n        AddHandler KeypadUserControl1.ButtonClicked, AddressOf OnKeypadButtonClicked\n    End Sub\n\n    Private Sub OnKeypadButtonClicked(ByVal value As String)\n        If currentInputBox IsNot Nothing Then\n            currentInputBox.Text &= value\n            currentInputBox.SelectionStart = currentInputBox.Text.Length\n            currentInputBox.Focus()\n        End If\n    End Sub\n\n    Private Sub TextBox_Enter(ByVal sender As System.Object, ByVal e As System.EventArgs) _\n        Handles LadingOrderQtyTextBox.Enter, AnotherTextBox.Enter\n        currentInputBox = CType(sender, TextBox)\n    End Sub\nEnd Class