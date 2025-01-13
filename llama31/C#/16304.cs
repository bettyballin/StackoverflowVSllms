routes.MapRoute(\n    name: "NotesNew",\n    template: "Notes/New/{type}/{id}",\n    defaults: new { controller = "Notes", action = "New" },\n    constraints: new { type = new EnumRouteConstraint(typeof(DataObjectType)) }\n);