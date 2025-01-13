public class DataAccessLayer\n{\n    private readonly string _connectionString;\n\n    public DataAccessLayer(string connectionString)\n    {\n        _connectionString = connectionString;\n    }\n\n    public List<ReportData> GetReportData(ReportRequest request)\n    {\n        // Database access logic using _connectionString\n        // Return the report data\n    }\n}