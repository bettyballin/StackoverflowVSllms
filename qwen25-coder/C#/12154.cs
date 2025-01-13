using System;\nusing System.Messaging;\nusing System.Transactions;\nusing System.Data.SqlClient;\n\nclass Program\n{\n    static void Main()\n    {\n        // Ensure MSDTC is running on your machine or server\n\n        using (TransactionScope scope = new TransactionScope())\n        {\n            try\n            {\n                // Insert data into SQL Server\n                using (SqlConnection connection = new SqlConnection("YourConnectionStringHere"))\n                {\n                    connection.Open();\n                    SqlCommand command = new SqlCommand("INSERT INTO YourTable VALUES (@Value)", connection);\n                    command.Parameters.AddWithValue("@Value", "Sample Data");\n                    command.ExecuteNonQuery();\n                }\n\n                // Send a message to an MSMQ queue\n                MessageQueue myQueue = new MessageQueue(@".\private$\YourQueueName")\n                {\n                    UseTransactional = true\n                };\n                myQueue.Send("Hello, MSMQ!");\n\n                // Complete the transaction scope to commit both operations\n                scope.Complete();\n            }\n            catch (Exception ex)\n            {\n                Console.WriteLine("An error occurred: " + ex.Message);\n                // If an exception occurs, the TransactionScope will go out of scope and roll back\n            }\n        }\n    }\n}