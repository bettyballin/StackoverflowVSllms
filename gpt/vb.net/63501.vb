Public Class Form1\n    Private Sub TextBox1_KeyDown(sender As Object, e As KeyEventArgs) Handles TextBox1.KeyDown\n        If e.KeyCode = Keys.Enter Then\n            ListBox1.Items.Add(TextBox1.Text)\n            TextBox1.Clear()\n            e.SuppressKeyPress = True ' To prevent the ding sound\n        End If\n    End Sub\nEnd Class