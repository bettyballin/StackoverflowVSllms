using System.Collections.Generic;\n   using System.ComponentModel.DataAnnotations;\n\n   public class User : IValidatableObject\n   {\n       public int Id { get; set; }\n\n       public string Name { get; set; }\n\n       public int Age { get; set; }\n\n       public IEnumerable<ValidationResult> Validate(ValidationContext validationContext)\n       {\n           var results = new List<ValidationResult>();\n\n           if (Age < 18 || Age > 99)\n           {\n               results.Add(new ValidationResult("Age must be between 18 and 99.", new[] { "Age" }));\n           }\n\n           if (string.IsNullOrWhiteSpace(Name))\n           {\n               results.Add(new ValidationResult("Name is required.", new[] { "Name" }));\n           }\n\n           return results;\n       }\n   }