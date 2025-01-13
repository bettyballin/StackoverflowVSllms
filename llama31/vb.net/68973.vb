Public Sub BuildErrorMessage(ByVal lbl As Label, ByVal ex As Exception)\n    If ex IsNot Nothing Then\n        lbl.Text += "<br />" & ex.Message\n        If ex.InnerException IsNot Nothing Then\n            BuildErrorMessage(lbl, ex.InnerException)\n        End If\n    End If\nEnd Sub