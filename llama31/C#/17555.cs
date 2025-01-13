using Microsoft.WindowsMobile.Status;\nusing System;\nusing System.Runtime.InteropServices;\nusing System.Windows.Forms;\n\npublic partial class Form1 : Form\n{\n    [DllImport("aygshell.dll")]\n    private static extern IntPtr SHSetAppKeyWndAssoc(IntPtr hwnd, uint dwAppKey);\n\n    [DllImport("aygshell.dll")]\n    private static extern IntPtr SHSetAppKeyWndAssoc(IntPtr hwnd, uint dwAppKey, uint dwFlags);\n\n    private const uint VK_TTALK = 0x5C;\n    private const uint SHCMBM_OVERRIDEKEY = 0x00000001;\n\n    public Form1()\n    {\n        InitializeComponent();\n        SHSetAppKeyWndAssoc(Handle, VK_TTALK);\n    }\n\n    protected override void WndProc(ref Message m)\n    {\n        if (m.Msg == WM_HOTKEY)\n        {\n            if ((int)m.LParam == VK_TTALK)\n            {\n                // Handle the Talk key press here\n                MessageBox.Show("Talk key pressed");\n            }\n        }\n        base.WndProc(ref m);\n    }\n}