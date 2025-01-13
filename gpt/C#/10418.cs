using System;\nusing System.Linq;\nusing System.Data.Linq;\n\npublic void ValidateChanges(DataContext context)\n{\n    var changes = context.GetChangeSet();\n    \n    foreach (var insert in changes.Inserts.OfType<MyEntity>())\n    {\n        ValidateEntity(insert);\n    }\n\n    foreach (var update in changes.Updates.OfType<MyEntity>())\n    {\n        ValidateEntity(update);\n    }\n    \n    // Add similar validation for Deletes if needed\n}\n\nprivate void ValidateEntity(MyEntity entity)\n{\n    // Add your validation logic here\n    if (string.IsNullOrEmpty(entity.SomeRequiredProperty))\n    {\n        throw new InvalidOperationException("SomeRequiredProperty cannot be null or empty.");\n    }\n\n    if (entity.SomeNumericProperty < 0)\n    {\n        throw new InvalidOperationException("SomeNumericProperty must be a positive number.");\n    }\n\n    // You can add more validation checks as required\n}