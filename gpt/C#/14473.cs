[HttpPost]\n   public IActionResult ConfirmTracker(int trackerId, string selectedTitle)\n   {\n       var tracker = _context.Trackers.Find(trackerId);\n       if (tracker != null)\n       {\n           var selectedItem = _context.TrackerItems\n               .FirstOrDefault(item => item.TrackerID == trackerId && item.Title == selectedTitle);\n\n           if (selectedItem != null)\n           {\n               // Update Tracker to "live"\n               tracker.Status = "live";\n               \n               // Optionally, clear other items or keep them as history\n               _context.TrackerItems.RemoveRange(_context.TrackerItems.Where(item => item.TrackerID == trackerId && item.Title != selectedTitle));\n               \n               _context.SaveChanges();\n           }\n       }\n\n       return Ok();\n   }