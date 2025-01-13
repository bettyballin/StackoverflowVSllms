public interface IConfiguration {\n    string DBConnectionString { get; }\n    // other configuration properties\n}\n\npublic class DevConfiguration : IConfiguration {\n    public string DBConnectionString => "dev_connection_string";\n}\n\npublic class MyClass {\n    private readonly IConfiguration _configuration;\n\n    public MyClass(IConfiguration configuration) {\n        _configuration = configuration;\n    }\n\n    public void MyMethod() {\n        // use _configuration.DBConnectionString\n    }\n}