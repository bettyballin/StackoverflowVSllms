protected override void WndProc(ref Message m)\n{\n    if (m.Msg == 0x020E) // WM_MOUSEHWHEEL\n    {\n        int tilt = (int)m.WParam;\n        // tilt value: -1 for left, 1 for right\n        // handle tilt event here\n    }\n    base.WndProc(ref m);\n}