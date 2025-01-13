// Assuming your entities are of type Subject with several properties\nvar query = data.Subjects\n                .Where(subject => subject.HasValue)\n                .Where(subject => someSetOfValues.Contains(subject.OtherValue));\n\n// More filtering, where you need to have two different options\nvar a = query\n        .Where(subject => subject.ForeignKey == null)\n        .Select(subject => new \n        {\n            subject.Property1,\n            subject.Property2,\n            // ... other properties\n        });\n\nvar b = query\n        .Where(subject => subject.ForeignKey != null)\n        .Where(subject => subject.ForeignEntity.Property == desiredValue)\n        .Select(subject => new \n        {\n            subject.Property1,\n            subject.Property2,\n            // ... other properties matching the selection in `a`\n        });\n\nquery = a.Union(b);\n\n// Final filter and then get result as a list\nvar list = query\n            .Where(subject => subject.LastRequirement)\n            .ToList();