Private Sub BindingNavigatorAddNewItem_MouseUp(sender As Object, e As MouseEventArgs)\n    Dim newProductId As String = InputBox("Give new product ID")\n\n    ' Validate the input if necessary\n    If String.IsNullOrEmpty(newProductId) Then\n        MessageBox.Show("Product ID cannot be empty.")\n        Return\n    End If\n\n    Try\n        ' Insert logic here (example with a DataAdapter and DataSet)\n        Dim sql As String = "INSERT INTO Products (ProductID, ProductName) VALUES (@ProductID, @ProductName)"\n        Using cmd As New SqlCommand(sql, YourConnectionString)\n            cmd.Parameters.AddWithValue("@ProductID", newProductId)\n            cmd.Parameters.AddWithValue("@ProductName", DataGridView1.CurrentRow.Cells(1).Value.ToString()) ' Assuming the second column is ProductName or another field\n\n            Dim rowsAffected = cmd.ExecuteNonQuery()\n            If rowsAffected > 0 Then\n                MessageBox.Show("Product added successfully.")\n            Else\n                MessageBox.Show("No product was added.")\n            End If\n        End Using\n\n    Catch ex As SqlException\n        ' Handle specific SQL errors here, like Constraint Violation\n        If ex.Number = 2627 Then ' Assuming error number 2627 is for duplicate key\n            MessageBox.Show("Error: This Product ID already exists.")\n        Else\n            MessageBox.Show("SQL Error: " & ex.Message)\n        End If\n\n    Catch ex As Exception\n        ' Handle any other exceptions here\n        MessageBox.Show("An error occurred: " & ex.Message)\n\n    Finally\n        ' Optional cleanup code here, if needed\n    End Try\nEnd Sub