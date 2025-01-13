public static string GetMimeTypeFromExtension(string extension)\n{\n    using (DirectoryEntry mimeMap = \n           new DirectoryEntry("IIS://Localhost/MimeMap"))\n    {\n        PropertyValueCollection propValues = mimeMap.Properties["MimeMap"];\n\n        foreach (object value in propValues)\n        {\n            IISOle.IISMimeType mimeType = (IISOle.IISMimeType)value;\n\n            if (extension == mimeType.Extension)\n            {\n                return mimeType.MimeType;\n            }\n        }\n\n        return null;\n\n    }\n}