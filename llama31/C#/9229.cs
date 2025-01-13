try\n{\n    var iptcMetadata = BitmapMetadata.GetQuery("/app13/irb/8bimiptc/iptc");\n    // Process the IPTC metadata\n}\ncatch (System.OverflowException ex)\n{\n    // Log the error or handle it as desired\n    Console.WriteLine($"Error reading IPTC metadata: {ex.Message}");\n}