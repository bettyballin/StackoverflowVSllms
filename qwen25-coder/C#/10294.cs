using System;\nusing System.IO.Ports;\n\nclass ReceiptPrinter {\n    private SerialPort _port;\n\n    public void Connect(string portName, int baudRate) {\n        _port = new SerialPort(portName, baudRate);\n        _port.Open();\n    }\n\n    public void PrintText(string text) {\n        if (_port != null && _port.IsOpen) {\n            byte[] buffer = System.Text.Encoding.ASCII.GetBytes(text + @"\n");\n            // Add ESC/POS commands if needed\n            _port.Write(buffer, 0, buffer.Length);\n        }\n    }\n\n    public void CutPaper() {\n        if (_port != null && _port.IsOpen) {\n            byte[] cmd = { 27, 105 }; // ASCII codes for ESC/i to cut paper (partial)\n            _port.Write(cmd, 0, cmd.Length);\n        }\n    }\n\n    public void Close() {\n        if (_port != null && _port.IsOpen) {\n            _port.Close();\n        }\n    }\n}