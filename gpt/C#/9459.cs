public class Person {\n       public int PersonId { get; set; }\n       public string Name { get; set; }\n   }\n\n   public class Employee : Person {\n       public string Department { get; set; }\n   }