[Route("cars/{carRego}/turn")]\n  public class TurnController : Controller\n  {\n      [HttpPost("left")]\n      public IActionResult TurnLeft(string carRego)\n      {\n          // Implementation\n      }\n  }