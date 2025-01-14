-- Before inserting into CustomMetadataTable, preprocess to extract StartDate\nDECLARE @ProcessDateTime datetime;\nSET @ProcessDateTime = CONVERT(datetime, @YourXMLColumn.value('(/Metadata/Value[@Key="StartDate"])[1]', 'varchar'), 126);\n\nINSERT INTO CustomMetadataTable (CustomMetadataColumn, StartDate)\nVALUES (@YourXMLColumn, @ProcessDateTime);