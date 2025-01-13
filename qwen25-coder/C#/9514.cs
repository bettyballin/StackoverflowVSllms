protected override void OnModelCreating(DbModelBuilder modelBuilder)\n     {\n         modelBuilder.Entity<DependentEntity>()\n             .HasOptional(e => e.PrincipalEntity) // or HasRequired\n             .WithOptionalPrincipal() // or WithRequiredPrincipal()\n             .Map(m => m.MapKey("UniqueFKColumnName"));\n     }