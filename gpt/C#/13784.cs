public class Student\n    {\n        public int StudentId { get; set; }\n        public string FirstName { get; set; }\n        public string LastName { get; set; }\n    }\n\n    public class SchoolContext : DbContext\n    {\n        public DbSet<Student> Students { get; set; }\n    }