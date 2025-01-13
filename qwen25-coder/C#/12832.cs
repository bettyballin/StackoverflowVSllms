using System.IO;\nusing NFlac.Encoder;\n\npublic static void EncodeWavToFlac(string wavFilePath, string flacFilePath)\n{\n    using (var reader = new FileStream(wavFilePath, FileMode.Open))\n    {\n        var encoderSettings = FlacEncoder.GetDefaultFileEncoderSettings();\n        encoderSettings.CompressionLevel = 5; // 0-8, higher is better compression but slower\n        encoderSettings.IsLossless = true;\n\n        using (var writer = new FileStream(flacFilePath, FileMode.Create))\n        using (var flacWriter = FlacEncoder.FromStream(writer, encoderSettings))\n        {\n            byte[] buffer = new byte[4096];\n            int bytesRead;\n            while ((bytesRead = reader.Read(buffer, 0, buffer.Length)) > 0)\n            {\n                flacWriter.ProcessData(buffer, bytesRead);\n            }\n\n            flacWriter.Flush();\n        }\n    }\n}