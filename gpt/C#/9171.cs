routes.MapRoute(\n        name: "Wizard",\n        url: "Wizard/{PartNum}/{PageId}",\n        defaults: new { controller = "Wizard", action = "Index", PageId = UrlParameter.Optional }\n    );