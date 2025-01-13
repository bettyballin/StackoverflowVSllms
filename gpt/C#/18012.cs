using System;\nusing System.Windows.Forms;\n\npublic class MyForm : Form\n{\n    private const int WM_MOUSEHWHEEL = 0x020E;\n\n    protected override void WndProc(ref Message m)\n    {\n        if (m.Msg == WM_MOUSEHWHEEL)\n        {\n            int tilt = (short)((m.WParam.ToInt32() >> 16) & 0xffff);\n            OnMouseHWheel(tilt);\n        }\n        base.WndProc(ref m);\n    }\n\n    private void OnMouseHWheel(int tilt)\n    {\n        // Handle the horizontal scroll tilt here\n        if (tilt > 0)\n        {\n            Console.WriteLine("Mouse wheel tilted to the right.");\n        }\n        else if (tilt < 0)\n        {\n            Console.WriteLine("Mouse wheel tilted to the left.");\n        }\n    }\n}