using Microsoft.SqlServer.Dts.Runtime;\n\n// ...\n\n// Create a new ForEachLoop executable\nExecutable executable = aSequence[0].Executables.Add("STOCK:ForEachLoop");\n\n// Set the name of the ForEachLoop\n((ForEachLoop)executable).Name = "a for each loop";\n\n// Set the ForEachEnumerator property\n((ForEachLoop)executable).ForEachEnumerator = ForEachEnumerator.ForEachFileEnumerator;\n\n// Set the CollectionEnumerator property\n((ForEachLoop)executable).CollectionEnumerator = true;\n\n// Set the Directory property\n((ForEachLoop)executable).Directory = @"C:\Example\Directory";\n\n// Set the FileNameRetrieval property\n((ForEachLoop)executable).FileNameRetrieval = FileNameRetrieval.FullyQualified;\n\n// Set the FileSpec property\n((ForEachLoop)executable).FileSpec = "*.txt";\n\n// Set the Recurse property\n((ForEachLoop)executable).Recurse = true;