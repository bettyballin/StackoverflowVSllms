SqlGuid parentCategoryId = (SqlGuid)row["ParentCategoryID"];\nif (parentCategoryId.IsNull)\n{\n    // handle null value\n}\nelse\n{\n    Guid guid = parentCategoryId.Value;\n    // use the GUID value\n}