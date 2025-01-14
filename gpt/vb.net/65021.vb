connection.Open()\n   Dim transaction As SqlTransaction = connection.BeginTransaction()\n   Try\n       Dim cmd As New SqlCommand("UPDATE your_table SET column1 = @value1 WHERE id = @id", connection, transaction)\n       cmd.Parameters.AddWithValue("@value1", newValue)\n       cmd.Parameters.AddWithValue("@id", id)\n       cmd.ExecuteNonQuery()\n\n       ' Commit the transaction\n       transaction.Commit()\n   Catch ex As Exception\n       ' Rollback the transaction if there is an error\n       transaction.Rollback()\n   Finally\n       connection.Close()\n   End Try