// Example of using Dapper to query from MySQL\nusing (var connection = new MySqlConnection("Server=localhost;database=yourdb;uid=user;pwd=password;"))\n{\n    var users = connection.Query<User>("SELECT * FROM Users");\n}