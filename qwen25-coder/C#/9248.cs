protected override void OnModelCreating(DbModelBuilder modelBuilder)\n{\n    modelBuilder.Entity<Article>()\n        .ToTable("Articles")\n        .HasKey(x => x.ID);\n\n    modelBuilder.Entity<NewsItem>()\n        .ToTable("NewsItems")\n        .HasKey(x => x.ID);\n\n    modelBuilder.Types<Content>().Configure(c => c.ToTable(c.ClrType.Name));\n}