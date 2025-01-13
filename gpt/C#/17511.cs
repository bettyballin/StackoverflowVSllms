using System;\nusing System.Data.Common;\nusing Devart.Data.Oracle;\nusing DevArtTry1.DataSet1TableAdapters;\n\nnamespace DevArtTry1\n{\n    class Program\n    {\n        static void Main(string[] args)\n        {\n            using (OracleConnection connection = new OracleConnection("your_connection_string"))\n            {\n                connection.Open();\n                using (OracleTransaction transaction = connection.BeginTransaction(System.Data.IsolationLevel.ReadCommitted))\n                {\n                    try\n                    {\n                        using (DataContext1 dc = new DataContext1(connection))\n                        {\n                            dc.Transaction = transaction; // Assign transaction to the DataContext\n\n                            Parent parent = new Parent();\n                            parent.Id = 1;\n                            parent.Name = "Parent 1";\n                            dc.Parents.InsertOnSubmit(parent);\n                            dc.SubmitChanges();\n                        }\n\n                        DataSet1.CHILDDataTable dt = new DataSet1.CHILDDataTable();\n                        DataSet1.CHILDRow row = dt.NewCHILDRow();\n                        row.ID = 1;\n                        row.PARENTID = 1;\n                        row.NAME = "Child 1";\n                        dt.AddCHILDRow(row);\n\n                        CHILDTableAdapter cta = new CHILDTableAdapter();\n                        cta.Connection = connection; // Use the same connection for the TableAdapter\n                        cta.Transaction = transaction; // Assign transaction to the TableAdapter\n                        cta.Update(dt);\n\n                        transaction.Commit();\n                        Console.WriteLine("Successfully inserted parent and child rows.");\n                    }\n                    catch (Exception ex)\n                    {\n                        transaction.Rollback();\n                        Console.WriteLine("An error occurred: " + ex.Message);\n                    }\n                }\n            }\n\n            Console.ReadLine();\n        }\n    }\n}