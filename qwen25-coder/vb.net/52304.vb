Private Sub saveBut_Click(sender As Object, e As EventArgs) Handles saveBut.Click\n    ' Validate and end current edit on BindingSource\n    Me.Validate()\n    TblPropertiesBindingSource.EndEdit()\n\n    ' Update the database using the TableAdapter\n    Try\n        PropertiesTableAdapter.Update(PropertiesDataSet.TblProperties)\n        MessageBox.Show("Changes saved successfully.")\n    Catch ex As Exception\n        MessageBox.Show("Error updating record: " & ex.Message)\n    End Try\nEnd Sub