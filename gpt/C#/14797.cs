[Authorize(Roles = "Admin")]\n   public IActionResult AdminOnlyAction()\n   {\n       // Action code here\n   }