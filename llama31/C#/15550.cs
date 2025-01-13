// Without LINQ to SQL\nstring connectionString = "Server=myServer;Database=myDB;User Id=myUser;Password=myPassword;";\nSqlConnection connection = new SqlConnection(connectionString);\nSqlCommand command = new SqlCommand("SELECT * FROM Customers", connection);\nconnection.Open();\nSqlDataReader reader = command.ExecuteReader();\nwhile (reader.Read())\n{\n    Console.WriteLine(reader["Name"].ToString());\n}\nconnection.Close();\n\n// With LINQ to SQL\nDataContext db = new DataContext(connectionString);\nvar customers = db.Customers;\nforeach (var customer in customers)\n{\n    Console.WriteLine(customer.Name);\n}