using System.ServiceProcess;\n\nstring serviceName = "YourServiceName";\n\nServiceController service = new ServiceController(serviceName);\nint processId = service.ServiceHandle.DangerousGetHandle().ToInt32();\nProcess process = Process.GetProcessById(processId);\nprocess.Kill();