var configuration = new Configuration();\nconfiguration.Configure(); // loads hibernate.cfg.xml file\n// Add your mappings here (can be Fluent or XML based)\nnew SchemaUpdate(configuration).Execute(true, true);