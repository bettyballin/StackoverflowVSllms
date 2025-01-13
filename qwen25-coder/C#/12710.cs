public Dictionary<int, List<byte[]>> ImageChunks = new Dictionary<int, List<byte[]>>();\npublic int ExpectedSequenceNumber = 0;\n\nprivate void ProcessChunk(byte[] chunk, int sequenceNumber, int totalChunks)\n{\n    if (!ImageChunks.ContainsKey(sequenceNumber))\n        ImageChunks[sequenceNumber] = new List<byte[]>();\n\n    ImageChunks[sequenceNumber].Add(chunk);\n\n    // Check if we have all chunks for the current image\n    if (ImageChunks[sequenceNumber].Count == totalChunks)\n    {\n        // We have a complete frame, reconstruct it\n        var imageData = ImageChunks[sequenceNumber]\n            .SelectMany(b => b).ToArray();\n        \n        // Process the imageData (e.g., display, save to disk)\n        HandleCompleteFrame(imageData);\n\n        // Remove this sequence number as we're done with it\n        ImageChunks.Remove(sequenceNumber);\n    }\n}\n\nprivate void HandleCompleteFrame(byte[] imageData)\n{\n    // This is where you would handle displaying or saving the reconstructed image.\n}