public interface IDataRepository\n{\n    DataSet PrefetchData();\n}\n\npublic class DataRepository : IDataRepository\n{\n    public DataSet PrefetchData()\n    {\n        // Load data from multiple tables into a dataset\n        var dataset = new DataSet();\n        // Load data logic here...\n        return dataset;\n    }\n}