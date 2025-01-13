// Using SQLite with Entity Framework Core\n   public class PatientContext : DbContext\n   {\n       public DbSet<Patient> Patients { get; set; }\n       \n       protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)\n       {\n           optionsBuilder.UseSqlite("Data Source=patients.db");\n       }\n   }\n\n   // Example usage\n   using (var context = new PatientContext())\n   {\n       context.Database.EnsureCreated();\n       context.Patients.Add(new Patient { FirstName = "John", LastName = "Doe" });\n       context.SaveChanges();\n\n       var searchResult = context.Patients.Where(p => p.FirstName.Contains("John") || p.LastName.Contains("Doe")).ToList();\n   }