Public Class CustomKnobControl\n    Private dragStartY As Integer\n    Private currentValue As Integer = 64 ' Assuming starting value is middle of your range (64)\n\n    Private Sub Label1_MouseDown(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles Label1.MouseDown\n        ' Start dragging when the mouse button is pressed on the label.\n        dragStartY = e.Y\n        Me.Cursor = Cursors.Hand\n    End Sub\n\n    Private Sub Label1_MouseMove(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles Label1.MouseMove\n        ' Adjust value while dragging.\n        If e.Button = MouseButtons.Left Then\n            Dim diffY As Integer = dragStartY - e.Y\n            currentValue += diffY / 5 ' Increment or decrement based on mouse movement. Adjust divisor as needed.\n            ' Clamp the current value between 0 and 127 (or your specific range).\n            currentValue = Math.Max(0, Math.Min( currentValue, 127))\n            ' Update the knob image based on the new value.\n            Label1.ImageKey = currentValue.ToString()\n            dragStartY = e.Y\n        End If\n    End Sub\n\n    Private Sub Label1_MouseUp(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles Label1.MouseUp\n        ' Stop dragging when mouse button is released.\n        Me.Cursor = Cursors.Default\n    End Sub\nEnd Class