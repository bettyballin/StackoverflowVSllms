Dim connectionString As String = "your_connection_string_here"\nDim sqlQuery As String = "SELECT * FROM YourTable"\n\nDim listOfT As List(Of YourType) = GetListOfT(Of YourType)(connectionString, sqlQuery)