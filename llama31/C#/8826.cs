using MyGeneration;\n\n// Create a new instance of the generator\nvar generator = new MyGeneration.Generator();\n\n// Specify the database connection and schema\ngenerator.Database = new MyGeneration.Database("your_database_connection_string");\ngenerator.Schema = "your_schema_name";\n\n// Specify the Castle ActiveRecord template\ngenerator.Template = new MyGeneration.Templates.CastleActiveRecordTemplate();\n\n// Generate the classes\ngenerator.Generate();\n\n// Save the generated classes to a file\ngenerator.SaveGeneratedClasses("path/to/output/folder");