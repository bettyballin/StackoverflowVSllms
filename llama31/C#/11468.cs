protected void Application_Start()\n{\n    //...\n    GlobalFilters.Filters.Add(new RequireHttpsAttribute());\n}