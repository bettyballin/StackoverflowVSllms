public class HomeController : Controller\n{\n    private readonly ApplicationDbContext _context;\n\n    public HomeController(ApplicationDbContext context)\n    {\n        _context = context;\n    }\n\n    public IActionResult Index()\n    {\n        var userId = GetCurrentUserId(); // Implement this to get current user's ID\n        var userSettings = _context.UserSettings.FirstOrDefault(us => us.UserId == userId);\n\n        ViewBag.FrameColor = userSettings?.FrameColor ?? "#000000"; // Default to black if not set\n\n        return View();\n    }\n\n    private int GetCurrentUserId()\n    {\n        // Implement logic to get current user's ID\n        return 1; // Example static user ID\n    }\n}