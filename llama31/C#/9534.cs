private Timer timer;\n\npublic Form1()\n{\n    InitializeComponent();\n    g = splitContainer1.Panel2.CreateGraphics();\n    splitContainer1.Panel2.Invalidate();\n    timer = new Timer();\n    timer.Interval = 10; // adjust this value to your liking\n    timer.Tick += new EventHandler(TimerTick);\n    timer.Start();\n}\n\nprivate void TimerTick(object sender, EventArgs e)\n{\n    Point currentPosition = Cursor.Position;\n    Point newPosition = RoundToNearest(gridsize, splitContainer1.Panel2.PointToClient(currentPosition));\n    Cursor.Position = splitContainer1.Panel2.PointToScreen(newPosition);\n}\n\nprivate void splitContainer1_Panel2_MouseMove(object sender, MouseEventArgs e)\n{\n    // do nothing here\n}