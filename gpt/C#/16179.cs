if (month < 1 || month > 12)\n  {\n      throw new ArgumentOutOfRangeException(nameof(month), "Month must be between 1 and 12.");\n  }