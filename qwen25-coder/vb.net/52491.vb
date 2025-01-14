Dim config As DatabaseConfigurationHandler = CType(System.Configuration.ConfigurationManager.GetSection("databases"), DatabaseConfigurationHandler)\n   If config IsNot Nothing Then\n       Dim dbConfig As Database = TryCast(config.Databases("DatabaseOne"), Database)\n       If dbConfig IsNot Nothing Then\n           Return dbConfig.DatabaseValue\n       End If\n   End If\n\n   ' Handle case where section or element is not found