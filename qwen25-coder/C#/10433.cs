public static void Register(HttpConfiguration config)\n   {\n       var cors = new EnableCorsAttribute("http://yourthirdpartysite.com", "*", "*")\n       {\n           SupportsCredentials = true\n       };\n       config.EnableCors(cors);\n   }