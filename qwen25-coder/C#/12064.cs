// Using Dapper to define a method that call a stored procedure.\nusing System;\nusing System.Collections.Generic;\nusing System.Data.SqlClient;\nusing Dapper;\n\npublic class DatabaseRepository\n{\n    private readonly string _connectionString;\n\n    public DatabaseRepository(string connectionString)\n    {\n        _connectionString = connectionString;\n    }\n\n    // Example of generated method for stored procedure GetEmployeeById\n    public Employee GetEmployeeById(int id)\n    {\n        using (var connection = new SqlConnection(_connectionString))\n        {\n            return connection.QueryFirstOrDefault<Employee>("GetEmployeeById", \n                new { Id = id }, commandType: System.Data.CommandType.StoredProcedure);\n        }\n    }\n\n    // Generated class for Employee object returned by the stored procedure\n    public class Employee\n    {\n        public int Id { get; set; }\n        public string Name { get; set; }\n        public string Position { get; set; }\n    }\n}