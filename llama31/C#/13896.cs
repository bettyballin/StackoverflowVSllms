[ApiController]\n[Route("api/[controller]")]\npublic class OnlineUsersController : ControllerBase {\n  [HttpGet]\n  public IActionResult GetOnlineUsers() {\n    using (var db = new YourDbContext()) {\n      var onlineUsers = db.Sessions\n        .Where(s => s.LastActivity > DateTime.Now.AddMinutes(-15))\n        .Select(s => new { s.UserId, s.LoginTime })\n        .ToList();\n      return Ok(onlineUsers);\n    }\n  }\n}