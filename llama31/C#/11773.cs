routes.MapRoute(\n    "StationeryShowHtml",\n    "Stationery/{id}",\n    new { controller = "Stationery", action = "ShowHtml" },\n    new { asHtml = true }\n);\n\nroutes.MapRoute(\n    "StationeryShow",\n    "Stationery/{id}",\n    new { controller = "Stationery", action = "Show" }\n);