using Dapper;\n\n// create a connection string\nstring connectionString = " Driver={Pervasive ODBC Client Interface};ServerName=myServer; DBQ=myDatabase; ";\n\n// create a query\nstring query = "SELECT CUSTOMERNBR, NAME FROM CUSTOMER";\n\n// execute the query\nusing (IDbConnection connection = new OdbcConnection(connectionString))\n{\n    connection.Open();\n    var customers = connection.Query<Customer>(query);\n    // do something with the results\n}\n\npublic class Customer\n{\n    public string CustomerNbr { get; set; }\n    public string Name { get; set; }\n}