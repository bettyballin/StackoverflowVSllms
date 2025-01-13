// Create a new BizTalk map\nMap myMap = new Map();\nmyMap.Name = "MultiInputSchemaMap";\n\n// Add source schemas\nSchema sourceSchema1 = new Schema("SourceSchema1.xsd");\nSchema sourceSchema2 = new Schema("SourceSchema2.xsd");\nmyMap.AddSourceSchema(sourceSchema1);\nmyMap.AddSourceSchema(sourceSchema2);\n\n// Add destination schema\nSchema destinationSchema = new Schema("DestinationSchema.xsd");\nmyMap.DestinationSchema = destinationSchema;\n\n// Perform field mappings (pseudo code)\nmyMap.AddLink(sourceSchema1.Field1, destinationSchema.FieldA);\nmyMap.AddLink(sourceSchema2.Field2, destinationSchema.FieldB);