public class MyWcfHost : ServiceBase\n{\n    private ServiceHost _serviceHost;\n\n    public MyWcfHost()\n    {\n        // Set the name of the service\n        this.ServiceName = "MyWCFServices";\n    }\n\n    protected override void OnStart(string[] args)\n    {\n        if (_serviceHost != null)\n        {\n            _serviceHost.Close();\n        }\n        \n        try\n        {\n            _serviceHost = new ServiceHost(typeof(MyWcfService));\n            _serviceHost.Open(); \n        }\n        catch (Exception ex)\n        {\n            // Handle exceptions during startup here\n            EventLog.SourceExists("MyWCFServicesErrs") ? EventLog.WriteEntry("MyWCFServicesErrs", $"Failed to start service: {ex.Message}", EventLogEntryType.Error) : throw;\n        }\n    }\n\n    protected override void OnStop()\n    {\n        if (_serviceHost != null)\n        {\n            _serviceHost.Close(); \n            _serviceHost = null; \n        }\n    }\n}