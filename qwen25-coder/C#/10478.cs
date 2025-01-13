using System.ComponentModel.DataAnnotations.Schema;\nusing Microsoft.EntityFrameworkCore;\n\nnamespace YourNamespace\n{\n    [Table("legacy_table_name")]\n    public class LegacyEntity\n    {\n        [Column("id_column")]\n        public int Id { get; set; }\n\n        [Column("name_column")]\n        public string Name { get; set; }\n    }\n\n    public class AppDbContext : DbContext\n    {\n        public DbSet<LegacyEntity> LegacyEntities { get; set; }\n\n        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)\n        {\n            optionsBuilder.UseSqlServer(@"Server=your_server;Database=your_database;Trusted_Connection=True;");\n        }\n    }\n}