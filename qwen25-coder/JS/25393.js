// Initialize DataTable with inline editing capability\n   $('#example').DataTable({\n       "ajax": "path/to/server/array",\n       "columns": [\n           { "data": "name" },\n           { "data": "position" }\n       ],\n       "select": true,\n       "responsive": true\n   });