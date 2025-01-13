[ImportMany]\npublic IEnumerable<IDataTransporter> Transporters { get; set; }\n\n[ImportMany]\npublic IEnumerable<IComPortDataTransporterSettings> ComPortSettings { get; set; }\n\n[ImportMany]\npublic IEnumerable<ITcpDataTransporterSettings> TcpSettings { get; set; }\n\npublic void ConfigureTransporters()\n{\n    foreach (var transporter in Transporters)\n    {\n        if (transporter is ComPortDataTransporter comPortTransporter)\n        {\n            var comPortSettings = ComPortSettings.FirstOrDefault();\n            comPortTransporter.BaudRate = comPortSettings.BaudRate;\n            comPortTransporter.StartBits = comPortSettings.StartBits;\n            comPortTransporter.StopBits = comPortSettings.StopBits;\n        }\n        else if (transporter is TcpDataTransporter tcpTransporter)\n        {\n            var tcpSettings = TcpSettings.FirstOrDefault();\n            tcpTransporter.IpAddress = tcpSettings.IpAddress;\n            tcpTransporter.Port = tcpSettings.Port;\n        }\n    }\n}