services.AddIdentity<ApplicationUser, IdentityRole>()\n        .AddEntityFrameworkStores<ApplicationDbContext>()\n        .AddDefaultTokenProviders();