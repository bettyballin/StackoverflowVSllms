using System;\nusing System.ServiceProcess;\nusing System.Timers;\n\npublic class MyService : ServiceBase\n{\n    private Timer _timer;\n\n    public MyService()\n    {\n        this.ServiceName = "MyService";\n    }\n\n    protected override void OnStart(string[] args)\n    {\n        _timer = new Timer();\n        _timer.Interval = 24 * 60 * 60 * 1000; // 24 hours\n        _timer.Elapsed += new ElapsedEventHandler(this.OnTimer);\n        _timer.Start();\n    }\n\n    protected override void OnStop()\n    {\n        _timer.Stop();\n    }\n\n    public void OnTimer(object sender, ElapsedEventArgs args)\n    {\n        // Code to access webservice and download dataset\n        // Code to insert data into SQL 2005 database\n    }\n\n    public static void Main()\n    {\n        ServiceBase.Run(new MyService());\n    }\n}