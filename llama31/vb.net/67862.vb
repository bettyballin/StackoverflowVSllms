' assume you have a database connection established\nDim orm : Set orm = New SimpleORM\n\n' define a class to map to a database table\nClass User\n    Public Id\n    Public Name\n    Public Email\nEnd Class\n\n' create a User object and populate it from the database\nDim user : Set user = orm.Load(User, "SELECT * FROM Users WHERE Id = 1")\n\n' access properties\nResponse.Write user.Name