routes.MapRoute(\n    name: "Bookmarks",\n    template: "bookmarks",\n    defaults: new { controller = "Bookmark", action = "Index" }\n);\n\nroutes.MapRoute(\n    name: "Bookmark",\n    template: "bookmark/{bookmarkId}",\n    defaults: new { controller = "Bookmark", action = "GetBookmark" }\n);