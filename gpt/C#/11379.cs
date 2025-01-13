public class YourDbContext : DbContext\n    {\n        protected override void OnModelCreating(DbModelBuilder modelBuilder)\n        {\n            modelBuilder.Entity<YourEntity>()\n                .Ignore(e => e.UnwantedKeyColumn);\n            \n            base.OnModelCreating(modelBuilder);\n        }\n    }