using System.ServiceProcess;\nServiceController controller  = new ServiceController();\n\ncontroller.MachineName = ".";\ncontroller.ServiceName = "mysql";\n\n// Start the service\ncontroller.Start();\n\n// Stop the service\ncontroller.Stop();