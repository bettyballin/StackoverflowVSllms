var connectionString = Configuration.GetConnectionString("DefaultConnection");\ndataAdapter.SelectCommand.Connection.ConnectionString = connectionString;