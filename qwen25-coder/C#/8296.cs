var user = _context.Users\n    .Include(u => u.GroupMember)\n    .FirstOrDefault(u => u.Id == userId);