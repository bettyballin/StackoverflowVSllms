private void ProcessExited(Object sender, EventArgs e)\n{\n    System.Diagnostics.Process proc = (System.Diagnostics.Process)sender;\n    Console.WriteLine($"Process {proc.Id} has exited.");\n}