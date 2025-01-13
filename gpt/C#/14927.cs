using System;\nusing System.Runtime.InteropServices;\nusing System.Windows.Forms;\n\npublic class GlassForm : Form\n{\n    [DllImport("dwmapi.dll", PreserveSig = false)]\n    public static extern void DwmExtendFrameIntoClientArea(IntPtr hwnd, ref Margins pMarInset);\n\n    [StructLayout(LayoutKind.Sequential)]\n    public struct Margins\n    {\n        public int Left;\n        public int Right;\n        public int Top;\n        public int Bottom;\n    }\n\n    public GlassForm()\n    {\n        this.Load += new EventHandler(GlassForm_Load);\n    }\n\n    void GlassForm_Load(object sender, EventArgs e)\n    {\n        if (Environment.OSVersion.Version.Major >= 6)\n        {\n            Margins margins = new Margins()\n            {\n                Left = -1,\n                Right = -1,\n                Top = -1,\n                Bottom = -1\n            };\n\n            IntPtr hwnd = this.Handle;\n            DwmExtendFrameIntoClientArea(hwnd, ref margins);\n        }\n    }\n\n    [STAThread]\n    static void Main()\n    {\n        Application.EnableVisualStyles();\n        Application.SetCompatibleTextRenderingDefault(false);\n        Application.Run(new GlassForm());\n    }\n}