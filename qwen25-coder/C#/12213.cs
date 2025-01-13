using System;\nusing System.ComponentModel.Composition;\n\n// Metadata for IDataTransporter\npublic interface IDataTransporterMetadata\n{\n    string TransportType { get; }\n}\n\n// Configuration classes\n[InheritedExport]\ninternal class ComPortConfig : IDataTransporterConfig\n{\n    public int BaudRate { get; set; }\n    public byte DataBits { get; set; }\n    public Parity Parity { get; set; }\n    // Other settings...\n}\n\n[InheritedExport]\ninternal class TcpConfig : IDataTransporterConfig\n{\n    public string IpAddress { get; set; }\n    public int Port { get; set; }\n    // Other settings...\n}\n\n// Exported classes with metadata\n[Export(typeof(IDataTransporter)), PartCreationPolicy(CreationPolicy.NonShared)]\n[ComPortDataTransporter("COM")]\ninternal class ComPortDataTransporter : IDataTransporter\n{\n    private readonly ComPortConfig _config;\n\n    [ImportingConstructor]\n    public ComPortDataTransporter([Import] ComPortConfig config)\n    {\n        _config = config;\n    }\n\n    // Implementation...\n}\n\n[Export(typeof(IDataTransporter)), PartCreationPolicy(CreationPolicy.NonShared)]\n[TcpDataTransporter("TCP")]\ninternal class TcpDataTransporter : IDataTransporter\n{\n    private readonly TcpConfig _config;\n\n    [ImportingConstructor]\n    public TcpDataTransporter([Import] TcpConfig config)\n    {\n        _config = config;\n    }\n\n    // Implementation...\n}\n\n// Factory to load and configure parts based on user input\ninternal class DataTransporterFactory\n{\n    [ImportMany(AllowRecomposition = true)]\n    private Lazy<IDataTransporter, IDataTransporterMetadata>[] _transporters;\n\n    public IDataTransporter Create(string type, IDataTransporterConfig config)\n    {\n        foreach (var transporter in _transporters)\n        {\n            if (string.Equals(transporter.Metadata.TransportType, type, StringComparison.OrdinalIgnoreCase))\n            {\n                // Configure using MEF's ImportEngine or manually set\n                return transporter.Value;\n            }\n        }\n        throw new ArgumentException("No matching transporter found.");\n    }\n}