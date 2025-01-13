// Reporting logic\npublic class ReportGenerator {\n    private readonly IReportRepository _repository;\n\n    public ReportGenerator(IReportRepository repository) {\n        _repository = repository;\n    }\n\n    public void GenerateReport() {\n        var data = _repository.GetData();\n        // Process data and generate report\n    }\n}\n\n// Repository interface\npublic interface IReportRepository {\n    IEnumerable<Data> GetData();\n}\n\n// Database-specific repository implementation\npublic class SqlServerReportRepository : IReportRepository {\n    public IEnumerable<Data> GetData() {\n        // SQL Server-specific data access logic\n    }\n}\n\n// Another database-specific repository implementation\npublic class OracleReportRepository : IReportRepository {\n    public IEnumerable<Data> GetData() {\n        // Oracle-specific data access logic\n    }\n}