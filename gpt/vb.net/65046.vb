Public Class MyUserControl\n    Inherits UserControl\n\n    Private WithEvents panel As New Panel()\n    Private vScrollBar As New VScrollBar()\n\n    Public Sub New()\n        ' Initialize the controls\n        Me.panel.Dock = DockStyle.Fill\n        Me.vScrollBar.Dock = DockStyle.Right\n\n        ' Add the controls to the user control\n        Me.Controls.Add(Me.panel)\n        Me.Controls.Add(Me.vScrollBar)\n\n        ' Set up the panel content for demonstration purposes\n        Dim content As New Label()\n        content.Text = "Some content that needs scrolling." & Environment.NewLine & String.Join(Environment.NewLine, Enumerable.Repeat("More content...", 50))\n        content.AutoSize = True\n        Me.panel.Controls.Add(content)\n\n        ' Adjust the scrollbar maximum value\n        Me.vScrollBar.Maximum = content.Height - Me.panel.Height\n\n        ' Handle the MouseWheel event for the panel\n        AddHandler Me.panel.MouseWheel, AddressOf Me.Panel_MouseWheel\n    End Sub\n\n    Private Sub Panel_MouseWheel(sender As Object, e As MouseEventArgs)\n        ' Scroll the panel content with the mouse wheel\n        Dim scrollChange As Integer = e.Delta / 120 * SystemInformation.MouseWheelScrollLines\n        Dim newValue As Integer = Me.vScrollBar.Value - scrollChange * 10 ' Adjust multiplier for smoother scrolling\n\n        ' Ensure the new value is within valid range\n        If newValue < Me.vScrollBar.Minimum Then\n            newValue = Me.vScrollBar.Minimum\n        ElseIf newValue > Me.vScrollBar.Maximum Then\n            newValue = Me.vScrollBar.Maximum\n        End If\n\n        Me.vScrollBar.Value = newValue\n        Me.panel.AutoScrollPosition = New Point(0, Me.vScrollBar.Value)\n    End Sub\nEnd Class