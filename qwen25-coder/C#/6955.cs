using System;\nusing System.Collections.Generic;\nusing System.Data.Linq;\nusing System.Linq;\n\npublic class YourDataContext : DataContext\n{\n    public Table<User> Users { get; set; }\n    public Table<Name> Names { get; set; }\n    public Table<ConnectName> ConnectNames { get; set; }\n\n    // Define the connection string in your constructor or through configuration.\n}\n\npublic class User\n{\n    public int UserId { get; set; }\n    public string FullName { get; set; }\n}\n\npublic class Name\n{\n    public int NameId { get; set; }\n    public string NameValue { get; set; }\n}\n\npublic class ConnectName\n{\n    public int NameId { get; set; }\n    public int UserId { get; set; }\n}\n\nclass Program\n{\n    static void Main()\n    {\n        var namesToSearchFor = new List<string> { "Carl", "Filip" };\n        var users = GetUsersByNames(namesToSearchFor);\n        \n        foreach (var user in users)\n        {\n            Console.WriteLine(user.FullName);\n        }\n    }\n\n    static IEnumerable<User> GetUsersByNames(List<string> searchNames)\n    {\n        using (var db = new YourDataContext())\n        {\n            // Select all names and their associated users.\n            var nameQueries = from cn in db.ConnectNames\n                              join n in db.Names on cn.NameId equals n.NameId\n                              select n;\n\n            // For each name we're searching for, filter the query again to include only those who match the criteria.\n            foreach (var name in searchNames)\n            {\n                var currentName = name;  // Copy variable to use inside lambda\n                nameQueries = nameQueries.Where(n => n.NameValue.Contains(currentName));\n            }\n\n            var userIds = nameQueries.Select(n => n.ConnectNames.UserId).Distinct();\n\n            // Get the users with matching IDs.\n            var users = from u in db.Users\n                        join id in userIds on u.UserId equals id\n                        select u;\n\n            return users.ToList();\n        }\n    }\n}