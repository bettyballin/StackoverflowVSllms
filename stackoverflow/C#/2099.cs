public DbConnection GetConnection(String connectionName)\n{\n   //Get the connection string info from web.config\n   ConnectionStringSettings cs= \n         ConfigurationManager.ConnectionStrings[connectionName];\n\n   //documented to return null if it couldn't be found\n   if (cs == null)\n      throw new ConfigurationErrorsException("Invalid connection name \""+connectionName+"\"");\n\n   //Get the factory for the given provider (e.g. "System.Data.SqlClient")\n   DbProviderFactory factory = \n         DbProviderFactories.GetFactory(cs.ProviderName);\n\n   //Undefined behaviour if GetFactory couldn't find a provider.\n   //Defensive test for null factory anyway\n   if (factory == null)\n      throw new Exception("Could not obtain factory for provider \""+cs.ProviderName+"\"");\n\n   //Have the factory give us the right connection object      \n   DbConnection conn = factory.CreateConnection();\n\n   //Undefined behaviour if CreateConnection failed\n   //Defensive test for null connection anyway\n   if (conn == null)\n      throw new Exception("Could not obtain connection from factory");\n\n   //Knowing the connection string, open the connection\n   conn.ConnectionString = cs.ConnectionString;\n   conn.Open()\n\n   return conn;\n}