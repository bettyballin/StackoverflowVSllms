var host = new MyCustomHost();\nhost.SetSelectedObjects(selectedObjects);\n\nvar engine = new Engine();\nengine.ProcessTemplate(templateContent, host);