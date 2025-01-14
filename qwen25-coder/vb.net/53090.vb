' Declare a global variable to hold the current input box\nPrivate WithEvents currentInputBox As TextBox\n\n' Handler for TextBox focus events (set this up in your form's load or initialization)\nPublic Sub FocusChanged(sender As Object, e As EventArgs) Handles LadingOrderQtyTextBox.GotFocus, AnotherTextBox.GotFocus\n    If TypeOf sender Is TextBox Then\n        currentInputBox = CType(sender, TextBox)\n        currentInputBox.SelectAll()\n    End If\nEnd Sub\n\n' Handler for button clicks (use one for all buttons, and set the Tag property of each button to the corresponding character)\nPrivate Sub InputButton_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button0.Click, Button1.Click, '... etc.\n    If currentInputBox IsNot Nothing Then\n        Dim button As Button = CType(sender, Button)\n        currentInputBox.Text &= button.Tag.ToString()\n        currentInputBox.SelectionStart = currentInputBox.Text.Length\n        currentInputBox.Focus()\n    End If\nEnd Sub