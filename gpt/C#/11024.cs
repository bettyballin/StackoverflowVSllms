using System;\nusing System.Collections.Generic;\nusing System.Data;\nusing IBatisNet.DataMapper.TypeHandlers;\n\npublic class StringListTypeHandler : BaseTypeHandler\n{\n    public override object GetValueByName(IDataReader dataReader, string columnName)\n    {\n        var value = dataReader[columnName] as string;\n        return value?.Split(',') ?? new List<string>();\n    }\n\n    public override object GetValueByIndex(IDataReader dataReader, int columnIndex)\n    {\n        var value = dataReader[columnIndex] as string;\n        return value?.Split(',') ?? new List<string>();\n    }\n\n    public override object ValueOf(string nullValue)\n    {\n        return nullValue.Split(',');\n    }\n\n    public override void SetParameter(IDataParameter dataParameter, object parameterValue)\n    {\n        var list = parameterValue as List<string>;\n        if (list != null)\n        {\n            dataParameter.Value = string.Join(",", list);\n        }\n        else\n        {\n            dataParameter.Value = DBNull.Value;\n        }\n    }\n}