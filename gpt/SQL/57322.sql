-- Adding a new article (stored procedure) to the publication\nEXEC sp_addarticle \n    @publication = 'YourPublicationName', \n    @article = 'NewStoredProcedure', \n    @source_object = 'NewStoredProcedure', \n    @type = 'logbased';\n\n-- Starting the snapshot agent to create a snapshot for the new article\nEXEC sp_startpublication_snapshot \n    @publication = 'YourPublicationName';