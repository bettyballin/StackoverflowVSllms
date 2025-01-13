using System;\nusing System.Data.SqlClient;\n\npublic void ExecuteProcedureAndGetXml()\n{\n    using (SqlConnection connection = new SqlConnection("YourConnectionString"))\n    {\n        SqlCommand command = new SqlCommand("YourStoredProcedure", connection);\n        command.CommandType = CommandType.StoredProcedure;\n\n        try\n        {\n            connection.Open();\n            XmlReader xmlReader = command.ExecuteXmlReader();\n\n            if (xmlReader != null)\n            {\n                // Process the XML data here\n                while (xmlReader.Read())\n                {\n                    // Your code to process XML\n                }\n            }\n            else\n            {\n                // Handle the case when no XML is returned (empty result set)\n                Console.WriteLine("No XML result was returned.");\n            }\n\n            xmlReader.Close();\n        }\n        catch (SqlException ex)\n        {\n            // Handle SQL-related exceptions\n            Console.WriteLine("SQL Error: " + ex.Message);\n        }\n        catch (TargetInvocationException tex)\n        {\n            // This exception should not be hit with the null check, but handle it just in case\n            if (tex.InnerException != null)\n                Console.WriteLine("Inner Exception: " + tex.InnerException.Message);\n            else\n                Console.WriteLine("TargetInvocationException: " + tex.Message);\n        }\n        catch (Exception ex)\n        {\n            // Handle other potential exceptions\n            Console.WriteLine("An error occurred: " + ex.Message);\n        }\n    }\n}