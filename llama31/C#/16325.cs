private void CheckIfApp(DirectoryEntry de)\n{\n    if(de.SchemaClassName.Equals("IIsWebDirectory") || de.SchemaClassName.Equals("IIsWebVirtualDir"))\n    {\n        if (de.Properties["AppFriendlyName"].Value != null)\n        {\n            string friendlyName = de.Properties["AppFriendlyName"].Value.ToString();\n\n            if (!friendlyName.Equals("Default Application"))\n            {\n                //do something...\n            }\n        }\n    }\n}