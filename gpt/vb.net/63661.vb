Private Sub NotifyIcon1_MouseClick(ByVal sender As System.Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles EMS.MouseDoubleClick\n    If e.Button = Windows.Forms.MouseButtons.Left Then\n        If associateForm.WindowState = FormWindowState.Normal And associateForm.Visible = True Then\n            associateForm.WindowState = FormWindowState.Minimized\n        Else\n            associateForm.WindowState = FormWindowState.Normal\n        End If\n\n        associateForm.Show()\n        associateForm.Focus()\n        'bring to front of other windows\n        associateForm.Activate()\n    End If\nEnd Sub