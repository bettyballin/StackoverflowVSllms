// Enable logging in the Crystal Reports .NET SDK\n   CrystalDecisions.Shared.ExportOptions exportOptions = new CrystalDecisions.Shared.ExportOptions();\n   exportOptions.ExportFormatType = CrystalDecisions.Shared.ExportFormatType.PortableDocFormat;\n   exportOptions.ExportDestinationType = CrystalDecisions.Shared.ExportDestinationType.DiskFile;\n   // Specify the path for the log file\n   exportOptions.LogFileName = @"C:\path\to\logfile.log";\n   // Set the log level to verbose\n   exportOptions.LogLevel = CrystalDecisions.Shared.LogLevel.Verbose;