class PoleDisplay : SerialPort\n{\n    private SerialPort srPort = null;\n\n    public PoleDisplay()\n    {\n        try\n        {\n            srPort = new SerialPort("COM1", 9600, Parity.None, 8, StopBits.One);\n            if (!srPort.IsOpen) srPort.Open();\n        }\n        catch { }\n    }\n\n    ~PoleDisplay()\n    {\n        srPort.Close();\n    }\n\n    // To clear Display.....\n    public void ClearDisplay()\n    {\n        // Assuming 0x0C is the clear display command, which is common in many POS displays.\n        byte[] clearCommand = new byte[] { 0x0C };\n        srPort.Write(clearCommand, 0, clearCommand.Length);\n    }\n\n    // Display Function\n    //'line' 1 for First line and 0 For second line\n    public void Display(string textToDisplay, int line)\n    {\n        // For setting the cursor position, you might use commands like 0x1F for the first line and 0x01 for the beginning of the line.\n        // You need to adjust these values based on your display's documentation.\n        byte[] cursorPositionCommand = new byte[] { (byte)(line == 0 ? 0x1F : 0x01) };\n        srPort.Write(cursorPositionCommand, 0, cursorPositionCommand.Length);\n        srPort.Write(textToDisplay);\n    }\n}