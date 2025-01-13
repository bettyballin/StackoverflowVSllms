// Controllers/UserController.cs\nusing Microsoft.AspNetCore.Mvc;\nusing System.Collections.Generic;\n\n[ApiController]\n[Route("api/[controller]")]\npublic class UserController : ControllerBase\n{\n    private static List<User> users = new List<User>\n    {\n        new User { Id = 1, Name = "John Doe", Email = "john@example.com" }\n    };\n\n    [HttpGet] // Get all users\n    public ActionResult<IEnumerable<User>> GetUsers()\n    {\n        return users;\n    }\n\n    [HttpGet("{id}")] // Get user by ID\n    public ActionResult<User> GetUserById(int id)\n    {\n        var user = users.FirstOrDefault(u => u.Id == id);\n        if (user == null)\n        {\n            return NotFound();\n        }\n        return user;\n    }\n\n    [HttpPost] // Create a new user\n    public IActionResult CreateUser(User newUser)\n    {\n        users.Add(newUser);\n        return CreatedAtAction(nameof(GetUserById), new { id = newUser.Id }, newUser);\n    }\n\n    [HttpPut("{id}")] // Update an existing user\n    public IActionResult UpdateUser(int id, User updatedUser)\n    {\n        var userIndex = users.FindIndex(u => u.Id == id);\n        if (userIndex < 0)\n        {\n            return NotFound();\n        }\n        users[userIndex] = updatedUser;\n        return NoContent();\n    }\n\n    [HttpDelete("{id}")] // Delete a user\n    public IActionResult DeleteUser(int id)\n    {\n        var userIndex = users.FindIndex(u => u.Id == id);\n        if (userIndex < 0)\n        {\n            return NotFound();\n        }\n        users.RemoveAt(userIndex);\n        return NoContent();\n    }\n}