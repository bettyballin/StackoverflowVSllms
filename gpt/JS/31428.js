ew Ajax.Updater('display', '/myform.aspx', {\n        onComplete: function() {\n            // Reinitialize the ASP.NET validation controls\n            Sys.Application.initialize();\n        }\n    });