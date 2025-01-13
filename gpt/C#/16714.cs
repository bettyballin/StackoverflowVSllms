using System;\nusing System.ServiceProcess;\nusing System.Timers;\n\npublic class MaintenanceService : ServiceBase\n{\n    private Timer timer;\n\n    protected override void OnStart(string[] args)\n    {\n        timer = new Timer();\n        timer.Interval = 60000; // Set interval to 1 minute\n        timer.Elapsed += new ElapsedEventHandler(OnTimedEvent);\n        timer.Start();\n    }\n\n    private void OnTimedEvent(object source, ElapsedEventArgs e)\n    {\n        // Your periodic task logic here\n    }\n\n    protected override void OnStop()\n    {\n        timer.Stop();\n        timer.Dispose();\n    }\n\n    public static void Main()\n    {\n        ServiceBase.Run(new MaintenanceService());\n    }\n}