// Example of routing in a RESTful API\nrouter.get('/question', function(req, res) {\n    // Logic to list questions\n});\n\nrouter.get('/question/:id', function(req, res) {\n    // Logic to get question details by ID\n});\n\nrouter.post('/question', function(req, res) {\n    // Logic to create a new question\n});\n\nrouter.put('/question/:id', function(req, res) {\n    // Logic to update an existing question\n});\n\nrouter.patch('/question/:id', function(req, res) {\n    // Logic to partially update a question\n});\n\nrouter.delete('/question/:id', function(req, res) {\n    // Logic to delete a question\n});