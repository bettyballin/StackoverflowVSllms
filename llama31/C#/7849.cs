string currentPath = this.Request?.CurrentExecutionFilePath;\nif (currentPath == null)\n{\n    // Log the issue or throw a more informative exception\n}\nstring[] parts = currentPath?.Split('/');