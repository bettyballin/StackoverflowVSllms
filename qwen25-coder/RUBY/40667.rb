User.joins(:events)\n    .group('users.id')\n    .having('COUNT(events.id) > 1')