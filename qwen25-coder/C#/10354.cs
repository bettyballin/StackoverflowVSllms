using System.ComponentModel.DataAnnotations;\n\n   public class Contact {\n       [Required(ErrorMessage = "Task name is required.")]\n       public string TaskName { get; set; }\n   }