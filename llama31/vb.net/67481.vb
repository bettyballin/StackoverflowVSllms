Private Sub MyForm_Activated(sender As Object, e As EventArgs) Handles Me.Activated\n    Me.BeginInvoke(New Action(Sub() Me.SendToBack()))\nEnd Sub