using NAudio.Wave;\nusing Concentus.Structs;\nusing Concentus.Enums;\nusing System.IO;\n\npublic class AudioConverter\n{\n    public void ConvertG729ToWav(string g729FilePath, string wavFilePath)\n    {\n        byte[] g729Data = File.ReadAllBytes(g729FilePath);\n        var decoder = new G729Decoder();\n\n        using (var waveStream = new WaveFileWriter(wavFilePath, new WaveFormat(8000, 16, 1)))\n        {\n            int frameSize = 10; // G729 frames are typically 10 bytes\n            byte[] pcmBuffer = new byte[160]; // 160 bytes for 16-bit PCM at 8000 Hz (20ms frame)\n            for (int i = 0; i < g729Data.Length; i += frameSize)\n            {\n                byte[] frame = new byte[frameSize];\n                Array.Copy(g729Data, i, frame, 0, frameSize);\n\n                short[] decodedFrame = decoder.Decode(frame);\n                Buffer.BlockCopy(decodedFrame, 0, pcmBuffer, 0, pcmBuffer.Length);\n\n                waveStream.Write(pcmBuffer, 0, pcmBuffer.Length);\n            }\n        }\n    }\n}\n\n// Usage\nvar converter = new AudioConverter();\nconverter.ConvertG729ToWav("input.g729", "output.wav");