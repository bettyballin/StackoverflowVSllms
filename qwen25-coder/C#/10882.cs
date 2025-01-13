using System;\nusing System.Data;\n\npublic class DataSetManager\n{\n    private readonly object _dataSetLock = new object();\n    private bool _isDataSetLocked = false;\n    private DataSet _dataSet;\n\n    public DataSetManager(DataSet dataSet)\n    {\n        _dataSet = dataSet;\n    }\n\n    public void LockDataSet()\n    {\n        lock (_dataSetLock)\n        {\n            _isDataSetLocked = true;\n        }\n    }\n\n    public void UnlockDataSet()\n    {\n        lock (_dataSetLock)\n        {\n            _isDataSetLocked = false;\n        }\n    }\n\n    public bool TryUpdateDataSet(Action<DataSet> updateAction)\n    {\n        lock (_dataSetLock)\n        {\n            if (!_isDataSetLocked)\n            {\n                updateAction(_dataSet);\n                return true;\n            }\n        }\n        return false;\n    }\n}