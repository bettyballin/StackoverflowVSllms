protected override void OnModelCreating(DbModelBuilder modelBuilder)\n{\n    modelBuilder.Entity<Paragraph>()\n        .HasKey(p => p.ParagraphID)\n        .ToTable("Paragraphs");\n\n    modelBuilder.Entity<ImageParagraph>()\n        .ToTable("ImageParagraph");\n\n    modelBuilder.Entity<LinkListParagraph>()\n        .HasKey(l => new { l.ParagraphID, l.LinkID })\n        .ToTable("LinkListParagraph");\n\n    // Configure the relationships if needed\n    modelBuilder.Entity<LinkListParagraph>()\n        .HasRequired<Paragraph>(p => p.Paragraph)\n        .WithOptional()\n        .WillCascadeOnDelete(false);\n\n    base.OnModelCreating(modelBuilder);\n}