Dim conn As ADODB.Connection\nDim cmd As ADODB.Command\nDim sql As String\nDim myDate As Date\n\n' Initialize the date\nmyDate = Date ' This will get the current date with time part as 00:00:00\n\n' Format the date to ensure it is in the correct format\nDim formattedDate As String\nformattedDate = Format(myDate, "yyyy-mm-dd") & " 00:00:00"\n\n' Initialize connection and command objects\nSet conn = New ADODB.Connection\nSet cmd = New ADODB.Command\n\n' Open the connection (replace with your actual connection string)\nconn.Open "Provider=SQLOLEDB;Data Source=YourServer;Initial Catalog=YourDatabase;User ID=YourUserID;Password=YourPassword;"\n\n' Prepare the SQL query\nsql = "INSERT INTO YourTable (YourDateColumn) VALUES ('" & formattedDate & "')"\n\n' Execute the query\ncmd.ActiveConnection = conn\ncmd.CommandText = sql\ncmd.Execute\n\n' Clean up\nconn.Close\nSet cmd = Nothing\nSet conn = Nothing