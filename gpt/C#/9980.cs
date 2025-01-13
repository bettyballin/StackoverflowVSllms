using System;\nusing System.Diagnostics;\n\nnamespace ScreenRecorder\n{\n    class Program\n    {\n        static void Main(string[] args)\n        {\n            string ffmpegPath = @"C:\path\to\ffmpeg.exe"; // Update with the actual path to ffmpeg.exe\n            string outputFilePath = @"C:\path\to\output.mp4"; // Update with your desired output file path\n\n            // Define the FFmpeg arguments for screen recording\n            string arguments = $"-f gdigrab -framerate 30 -i desktop -c:v libx264 -r 30 -pix_fmt yuv420p \"{outputFilePath}\"";\n\n            // Start the FFmpeg process\n            Process ffmpeg = new Process();\n            ffmpeg.StartInfo.FileName = ffmpegPath;\n            ffmpeg.StartInfo.Arguments = arguments;\n            ffmpeg.StartInfo.UseShellExecute = false;\n            ffmpeg.StartInfo.RedirectStandardOutput = true;\n            ffmpeg.StartInfo.RedirectStandardError = true;\n            ffmpeg.StartInfo.CreateNoWindow = true;\n\n            ffmpeg.Start();\n\n            Console.WriteLine("Recording... Press 'q' to stop.");\n\n            // Monitor the FFmpeg process\n            while (!ffmpeg.HasExited)\n            {\n                if (Console.KeyAvailable && Console.ReadKey(true).Key == ConsoleKey.Q)\n                {\n                    ffmpeg.StandardInput.Write("q");\n                    break;\n                }\n            }\n\n            ffmpeg.WaitForExit();\n            Console.WriteLine("Recording stopped.");\n        }\n    }\n}