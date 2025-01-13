[ApiController]\n[Route("api/[controller]")]\npublic class QueueController : ControllerBase\n{\n    [HttpPost("enqueue")]\n    public IActionResult Enqueue([FromBody] string userId)\n    {\n        UserQueue.EnqueueUser(userId);\n        return Ok(new { Position = UserQueue.GetUserPosition(userId)});\n    }\n\n    [HttpPost("dequeue")]\n    public IActionResult Dequeue()\n    {\n        var userId = UserQueue.DequeueUser();\n        if (userId != null)\n        {\n            return Ok(new { UserId = userId });\n        }\n        return NotFound();\n    }\n\n    [HttpGet("position/{userId}")]\n    public IActionResult GetPosition(string userId)\n    {\n        return Ok(new { Position = UserQueue.GetUserPosition(userId) });\n    }\n}