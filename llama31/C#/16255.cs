using System.DirectoryServices;\n\npublic void DisplayValue(DirectoryEntry de)\n{\n    if (de.Children != null)\n    {\n        foreach (DirectoryEntry child in de.Children)\n        {\n            PropertyCollection pc = child.Properties;\n            foreach (string propertyName in pc.PropertyNames)\n            {\n                PropertyValueCollection pvc = pc[propertyName];\n                Console.WriteLine($"Name: {propertyName}");\n                Console.WriteLine($"Value: {string.Join(", ", pvc)}");\n            }\n        }\n    }\n}