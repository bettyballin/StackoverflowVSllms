With Me.rtbDoc\n        If .SelectionFont IsNot Nothing Then\n            Dim currentFont As System.Drawing.Font = .SelectionFont\n            Dim newFontStyle As System.Drawing.FontStyle\n\n            If .SelectionFont.Bold = True Then\n                newFontStyle = currentFont.Style - Drawing.FontStyle.Bold\n            Else\n                newFontStyle = currentFont.Style + Drawing.FontStyle.Bold\n            End If\n\n            .SelectionFont = New Drawing.Font(currentFont.FontFamily, currentFont.Size, newFontStyle)\n        End If\n    End With