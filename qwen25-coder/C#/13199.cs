using System;\nusing System.Linq;\n\nnamespace EFSample\n{\n    public class Program\n    {\n        public static void Main()\n        {\n            using (var context = new BloggingContext())\n            {\n                // Displays all Blogs from the database\n                foreach (var blog in context.Blogs)\n                {\n                    Console.WriteLine(blog.Url);\n                }\n            }\n        }\n    }\n\n    public class BloggingContext : DbContext\n    {\n        public Dbset<Blog> Blogs { get; set; }\n    }\n\n    public class Blog\n    {\n        public int BlogId { get; set; }\n        public string Url { get; set; }\n    }\n}