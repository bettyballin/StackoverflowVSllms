Private Sub dgvFMSelected_DragDrop(ByVal sender As System.Object, ByVal e As System.Windows.Forms.DragEventArgs) Handles dgvFMSelected.DragDrop\n    If sourceGrid IsNot dgvFMSelected Then\n        Try\n            Me.SelectFM(CType(e.Data.GetData(GetType(DataGridViewSelectedRowCollection)), DataGridViewSelectedRowCollection))\n        Finally\n            e.Effect = DragDropEffects.None\n        End Try\n    End If\nEnd Sub\n\nPrivate Sub dgvFMAvailable_DragDrop(ByVal sender As System.Object, ByVal e As System.Windows.Forms.DragEventArgs) Handles dgvFMAvailable.DragDrop\n    If sourceGrid IsNot dgvFMAvailable Then\n        Try\n            Me.SelectFM(CType(e.Data.GetData(GetType(DataGridViewSelectedRowCollection)), DataGridViewSelectedRowCollection))\n        Finally\n            e.Effect = DragDropEffects.None\n        End Try\n    End If\nEnd Sub