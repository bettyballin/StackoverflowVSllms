Ext.onReady(function() {\n    if (self === top) {\n        // Page is not in an iframe\n        Ext.getBody().show();\n    } else {\n        // Page is in an iframe\n        top.location = self.location;\n    }\n});