# Example Command Using SQLPackage (must be installed)\nSQLPackage.exe `\n    /a:Extract `\n    /tf:"C:\Scripts\YourDatabaseSchema.dacpac" `\n    /scs:"Data Source=YourServerName;Integrated Security=True;Initial Catalog=YourDatabaseName;" `\n    /p:ExcludedTypes=`"Views,StoredProcedures"` `\n    /p:TypeToScript=`"(System.String[])[Table]"` \\\n    /p:ExcludeObjectList=`"[dbo].[ExcludedTable1];[dbo].[ExcludedTable2]"` \\\n    /p:SchemaOnly