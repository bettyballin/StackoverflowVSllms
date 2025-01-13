[ApiController]\n[Route("[controller]")]\npublic class MyController : ControllerBase\n{\n    [HttpGet("{id}")]\n    public IActionResult GetById(int id)\n    {\n        try\n        {\n            // Simulating a method call that could throw ArgumentNullException or ArgumentException\n            var result = SomeMethodThatCouldThrowException(id);\n            return Ok(result);\n        }\n        catch (ArgumentNullException ex)\n        {\n            return BadRequest(new { error = "Invalid request data", details = ex.Message });\n        }\n        catch (ArgumentException ex)\n        {\n            return BadRequest(new { error = "Invalid argument", details = ex.Message });\n        }\n    }\n\n    private object SomeMethodThatCouldThrowException(int id)\n    {\n        if (id <= 0)\n        {\n            throw new ArgumentException("Id must be greater than zero.", nameof(id));\n        }\n        // Some logic here...\n        return null;\n    }\n}