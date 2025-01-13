using System;\nusing System.Data;\nusing System.ServiceModel;\n\n[ServiceContract(CallbackContract = typeof(IClientCallback))]\npublic interface IDataService\n{\n    [OperationContract]\n    DataSet GetData();\n\n    [OperationContract(IsOneWay = true)]\n    void RefreshData();\n}\n\npublic interface IClientCallback\n{\n    [OperationContract(IsOneWay = true)]\n    void OnDataChanged();\n}\n\n[ServiceBehavior(InstanceContextMode = InstanceContextMode.Single)]\npublic class DataService : IDataService\n{\n    private DataSet _dataSet = new DataSet();\n    public static event Action DataChanged;\n\n    public DataSet GetData()\n    {\n        return _dataSet;\n    }\n\n    public void RefreshData()\n    {\n        // Refresh dataset logic here\n        DataChanged?.Invoke();\n    }\n\n    public static void NotifyClients()\n    {\n        DataChanged?.Invoke();\n    }\n}