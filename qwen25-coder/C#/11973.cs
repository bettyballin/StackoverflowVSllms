using System.Diagnostics;\nusing Microsoft.AspNetCore.Mvc;\n\n[ApiController]\n[Route("[controller]")]\npublic class OutputController : ControllerBase\n{\n    private static Process _process;\n    private static string _lastLineRead = "";\n\n    public OutputController()\n    {\n        if (_process == null)\n        {\n            StartProcess();\n        }\n    }\n\n    void StartProcess()\n    {\n        _process = new Process\n        {\n            StartInfo = new ProcessStartInfo\n            {\n                FileName = "YourConsoleApp.exe",\n                RedirectStandardOutput = true,\n                UseShellExecute = false,\n                CreateNoWindow = true\n            }\n        };\n\n        _process.OutputDataReceived += (sender, e) =>\n        {\n            if (!string.IsNullOrEmpty(e.Data))\n            {\n                _lastLineRead = e.Data;\n            }\n        };\n        \n        _process.Start();\n        _process.BeginOutputReadLine();\n    }\n\n    [HttpGet("getline")]\n    public ActionResult<string> GetLine()\n    {\n        var lineToReturn = _lastLineRead;\n        _lastLineRead = "";\n        return lineToReturn;\n    }\n}