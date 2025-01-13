using System;\nusing System.Management;\n\nclass ProcessStartWatcher\n{\n    private ManagementEventWatcher _watcher;\n\n    public ProcessStartWatcher(string processName)\n    {\n        _watcher = new ManagementEventWatcher();\n        _watcher.Query = "SELECT * FROM Win32_ProcessStartTrace WHERE FileName='" + processName + "'";\n        _watcher.EventArrived += new EventArrivedEventHandler(ProcessStarted);\n        _watcher.Start();\n    }\n\n    private void ProcessStarted(object sender, EventArrivedEventArgs e)\n    {\n        Console.WriteLine("Process started: " + e.NewEvent["FileName"]);\n    }\n\n    public void Stop()\n    {\n        _watcher.Stop();\n    }\n}