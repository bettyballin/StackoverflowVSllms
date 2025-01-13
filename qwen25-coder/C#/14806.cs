// For LINQ to SQL, setting up a type description provider.\npublic static ContextName()\n{\n    foreach (Type type in System.Reflection.Assembly.GetExecutingAssembly().GetTypes())\n    {\n        if (type.GetCustomAttributes(typeof(System.Data.Linq.Mapping.TableAttribute), true).Length > 0)\n        {\n            System.ComponentModel.TypeDescriptor.AddProvider(\n                new Hyper.ComponentModel.HyperTypeDescriptionProvider(type),\n                type);\n        }\n    }\n}