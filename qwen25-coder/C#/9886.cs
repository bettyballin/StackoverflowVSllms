private void compose()\n{\n    try {\n        var catalog = new AggregateCatalog();\n        \n        // Add explicit parts for testing purposes\n        catalog.Catalogs.Add(new TypeCatalog(\n            typeof(LyanController),\n            typeof(VialisController)\n        ));\n                \n        var container = new CompositionContainer(catalog);\n\n        container.AddPart(this);\n        bool success = container.Compose();\n\n        if (!success)\n            Console.WriteLine("Composition failed, no exports were found and thus imports could not be satisfied.");\n    } catch (Exception ex) {\n        Console.WriteLine($"Error during composition: {ex.Message}");\n    }\n}