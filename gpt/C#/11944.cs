protected void TestSubmit_ServerClick(object sender, EventArgs e)\n{\n    // Initialize the database connector.\n    SqlConnection connectSQL = new SqlConnection();\n\n    // Send the connection string.\n    connectSQL.ConnectionString = @"Data Source=localhost\SQLEXPRESS;Initial Catalog=Inputs;Integrated Security=SSPI";\n\n    try\n    {\n        // Setup our command.\n        SqlCommand theCommand = new SqlCommand("SELECT ApplicationName FROM Inputs", connectSQL);\n\n        // Write the stored value in the text boxes.\n        connectSQL.Open();\n\n        SqlDataReader theReader = theCommand.ExecuteReader();\n\n        // Clear existing items to avoid duplicates\n        DropDownList1.Items.Clear();\n\n        // Iterate through the data and add to the DropDownList\n        while (theReader.Read())\n        {\n            DropDownList1.Items.Add(theReader["ApplicationName"].ToString());\n        }\n\n        theReader.Close();\n        connectSQL.Close();\n    }\n    catch (Exception ee)\n    {\n        // Log the exception or display it in a user-friendly way\n        Console.WriteLine("Error: " + ee.Message);\n    }\n}