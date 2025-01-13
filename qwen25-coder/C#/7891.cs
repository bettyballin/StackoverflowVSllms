// In your ASP.NET MVC WebAPI project\n[Route("api/[controller]")]\npublic class CommandController : ControllerBase\n{\n    private readonly IHubContext<DataReloadSignalRHub> _hubContext;\n\n    public CommandController(IHubContext<DataReloadSignalRHub> hubContext)\n    {\n        _hubContext = hubContext;\n    }\n\n    [HttpPost("reload")]\n    public async Task<IActionResult> ReloadData()\n    {\n        // You can also use a database, messaging queue, or SignalR to notify the service\n        await _hubContext.Clients.All.SendAsync("ReloadData");\n        return Ok(new { message = "Reload command sent" });\n    }\n}