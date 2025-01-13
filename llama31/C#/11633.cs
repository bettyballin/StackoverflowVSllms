using System;\nusing System.Runtime.InteropServices;\nusing System.Windows.Forms;\n\nclass IRReceiver\n{\n    [DllImport("user32.dll")]\n    static extern bool RegisterRawInputDevices(RAWINPUTDEVICE[] devices, int numDevices, int size);\n\n    [DllImport("user32.dll")]\n    static extern int GetRawInputData(IntPtr hRawInput, uint uiCommand, IntPtr pData, ref int pcbSize, int wSizeHeader);\n\n    private const int WM_INPUT = 0x100;\n    private const int RID_INPUT = 0x10000003;\n\n    private RAWINPUTDEVICE[] _devices = new RAWINPUTDEVICE[1];\n\n    public IRReceiver()\n    {\n        _devices[0].usUsagePage = 0xFFBC; // IR receiver usage page\n        _devices[0].usUsage = 0x0001; // IR receiver usage ID\n        _devices[0].dwFlags = RIDEV_INPUTSINK;\n        _devices[0].hwndTarget = IntPtr.Zero;\n\n        RegisterRawInputDevices(_devices, 1, Marshal.SizeOf(typeof(RAWINPUTDEVICE)));\n    }\n\n    protected override void WndProc(ref Message m)\n    {\n        if (m.Msg == WM_INPUT)\n        {\n            IntPtr hRawInput = m.LParam;\n            uint uiCommand = RID_INPUT;\n            IntPtr pData = IntPtr.Zero;\n            int pcbSize = 0;\n            int wSizeHeader = Marshal.SizeOf(typeof(RAWINPUTHEADER));\n\n            GetRawInputData(hRawInput, uiCommand, pData, ref pcbSize, wSizeHeader);\n\n            // Process the raw input data (e.g., extract the pressed button code)\n            byte[] rawData = new byte[pcbSize];\n            Marshal.Copy(pData, rawData, 0, pcbSize);\n\n            // Handle the pressed button...\n        }\n\n        base.WndProc(ref m);\n    }\n}\n\n[StructLayout(LayoutKind.Sequential)]\npublic struct RAWINPUTDEVICE\n{\n    public ushort usUsagePage;\n    public ushort usUsage;\n    public int dwFlags;\n    public IntPtr hwndTarget;\n}\n\n[StructLayout(LayoutKind.Sequential)]\npublic struct RAWINPUTHEADER\n{\n    public uint dwType;\n    public uint dwSize;\n    public IntPtr hDevice;\n    public IntPtr wParam;\n}