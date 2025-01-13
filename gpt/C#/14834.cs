[Table(Name = "Author")]\n    public class Author {\n        [Column(IsPrimaryKey = true)]\n        public int ID { get; set; }\n        \n        [Column]\n        public string LastName { get; set; }\n        \n        [Column]\n        public string FirstName { get; set; }\n        \n        [Column]\n        public string XmlField { get; set; } // Assuming the XML field is stored as a string\n    }