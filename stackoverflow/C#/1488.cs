var p = new Process\n            {\n                StartInfo = new ProcessStartInfo("php", path)\n                {\n                    RedirectStandardOutput = true,\n                    RedirectStandardError = true,\n                    UseShellExecute = false,\n                    CreateNoWindow = true,\n                    WorkingDirectory = workingDir\n                }\n            };