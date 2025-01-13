using System;\n\npublic class ActivationService\n{\n    // Method to generate a new GUID token\n    public static string GenerateActivationToken()\n    {\n        return Guid.NewGuid().ToString();\n    }\n\n    // Simulate storing the token with associated data in a database (pseudo-code)\n    public void StoreToken(string email, string token)\n    {\n        // Assuming you use parametersized queries or an ORM to prevent SQL injection\n        // Insert into Users(email, activation_token) values(@email, @token);\n    }\n\n    // Validate the token from the URL (pseudo-code)\n    public bool IsValidationToken(string token)\n    {\n        // Query your database to see if a user has this token and hasn't used it yet\n        // Select count(*) from Users where activation_token = @token AND is_used = 0;\n        return true; // Simplified for example\n    }\n}