foreach (var insert in changes.Inserts)\n{\n    context.Validate(insert);\n}