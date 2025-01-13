static bool HasJpegExtension(string filename)\n{\n    // add other possible extensions here\n    return Path.GetExtension(filename).Equals(".jpg", StringComparison.InvariantCultureIgnoreCase)\n        || Path.GetExtension(filename).Equals(".jpeg", StringComparison.InvariantCultureIgnoreCase);\n}