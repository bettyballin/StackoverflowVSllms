PropertyDescriptor[] properties = TypeDescriptor.GetProperties(this);\n //Add as necessary\n string[] propertiesToTagForORM = { "Name", "Category", "Description" };\n\n foreach (string propname in propertiesToTagForORM)\n        {\n            PropertyDescriptor prop = properties[propname];\n            if (prop != null)\n            {\n                AttributeCollection runtimeAttributes = prop.Attributes;\n                // make a copy of the original attributes \n                // but make room for one extra attribute\n                Attribute[] attrs = new Attribute[runtimeAttributes.Count + 1];\n                runtimeAttributes.CopyTo(attrs, 0);\n                attrs[runtimeAttributes.Count] = new BrowsableAttribute(false); \n\n                prop = TypeDescriptor.CreateProperty(this.GetType(), propname, prop.PropertyType, attrs);\n                properties[propname] = prop;\n            }\n        }\n}