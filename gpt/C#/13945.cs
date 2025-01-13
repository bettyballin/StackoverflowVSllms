using System.ComponentModel.DataAnnotations;\n\n   public class User\n   {\n       [Key]\n       public int Id { get; set; }\n\n       [Required]\n       [StringLength(100)]\n       public string Name { get; set; }\n\n       [Range(18, 99)]\n       public int Age { get; set; }\n   }