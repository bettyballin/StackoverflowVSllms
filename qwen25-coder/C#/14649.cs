using System;\nusing System.Collections.Generic;\nusing System.IO;\nusing System.Linq;\nusing System.Threading.Tasks;\nusing Xabe.FFmpeg;\n\npublic class VideoCreator\n{\n    public async Task CreateVideoFromImages(string inputFolder, string outputFile, double frameRate = 1.0)\n    {\n        // Ensure the FFmpeg binaries are available\n        await FFmpeg.SetExecutablesPathAsync("./ffmpeg");\n\n        // Get all jpeg files in the folder and order by name\n        var images = Directory.GetFiles(inputFolder, "*.jpg")\n                              .OrderBy(f => f)\n                              .Select(filePath => new FileInfo(filePath))\n                              .ToList();\n\n        // Define the output video parameters\n        var stream = await Stream.Video.Build()\n                          .SetVideoCodec(VideoCodec.LibX264)\n                          .Build();\n        \n        // Create the input options for each image with specified delay between frames\n        foreach (var file in images)\n        {\n            stream.AddInput(file).Loop(true, 0, TimeSpan.FromSeconds(frameRate)).Delay(TimeSpan.FromMilliseconds(-1000 / frameRate));\n        }\n\n        // Build the output file and add the stream to it\n        var conversion = await Conversion.New()\n                                         .AddStream(stream)\n                                         .SetOutput(new FileInfo(outputFile))\n                                         .Start();\n        \n        // Wait for the conversion to finish\n        await Task.WhenAll(conversion);\n    }\n}\n\n// Example usage:\npublic static async Task Main(string[] args)\n{\n    var creator = new VideoCreator();\n    await creator.CreateVideoFromImages(@"C:\path\to\images", @"C:\output\video.mp4", 1.0); // 1 frame per second\n}