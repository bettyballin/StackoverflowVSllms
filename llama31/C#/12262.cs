public interface IDataTransporter\n{\n    // common methods for data transport\n}\n\npublic interface IComPortDataTransporterSettings\n{\n    int BaudRate { get; set; }\n    int StartBits { get; set; }\n    int StopBits { get; set; }\n    // other COM port settings\n}\n\npublic interface ITcpDataTransporterSettings\n{\n    string IpAddress { get; set; }\n    int Port { get; set; }\n    // other TCP settings\n}\n\n[Export(typeof(IDataTransporter))]\npublic class ComPortDataTransporter : IDataTransporter, IComPortDataTransporterSettings\n{\n    // implementation\n}\n\n[Export(typeof(IDataTransporter))]\npublic class TcpDataTransporter : IDataTransporter, ITcpDataTransporterSettings\n{\n    // implementation\n}