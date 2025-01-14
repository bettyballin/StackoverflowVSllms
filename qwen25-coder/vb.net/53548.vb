Imports System.Data.SqlClient\n\nSub ProcessOrderResults(orderId As Integer)\n    Using connection As New SqlConnection("your_connection_string_here")\n        Dim command As New SqlCommand("getOrder", connection)\n        command.CommandType = CommandType.StoredProcedure\n\n        ' Add parameters if any\n        command.Parameters.AddWithValue("@orderId", orderId)\n\n        Try\n            connection.Open()\n            Dim reader As SqlDataReader = command.ExecuteReader()\n\n            ' Read the first result set\n            While reader.Read()\n                Dim orderAddress As String = reader("order_address").ToString()\n                Dim orderNumber As Integer = Convert.ToInt32(reader("order_number"))\n                Console.WriteLine($"Order Address: {orderAddress}, Order Number: {orderNumber}")\n            End While\n\n            ' Move to the next result set\n            If reader.NextResult() Then\n                ' Read the second result set\n                While reader.Read()\n                    Dim item As String = reader("item").ToString()\n                    Dim numberOfItems As Integer = Convert.ToInt32(reader("number_of_items"))\n                    Dim cost As Decimal = Convert.ToDecimal(reader("cost"))\n                    Console.WriteLine($"Item: {item}, Number of Items: {numberOfItems}, Cost: {cost}")\n                End While\n            End If\n\n        Catch ex As Exception\n            Console.WriteLine("Error: " & ex.Message)\n        Finally\n            connection.Close()\n        End Try\n    End Using\nEnd Sub