// Create the definition or use existing one\n   int definitionId = 1; // Example definition ID\n   BuildRequest request = new BuildRequest() { DefinitionId = definitionId };\n   \n   var build = await buildServer.QueueBuildAsync(request);