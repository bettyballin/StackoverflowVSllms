using System;\nusing System.Collections.Generic;\nusing System.ServiceModel;\n\n[ServiceContract(Namespace = "http://example.com/service")]\npublic interface IMyService\n{\n    [OperationContract]\n    string ReverseString(string input);\n\n    [OperationContract]\n    KeyValuePair<int, string>[] GetKeyValuePairs();\n}\n\npublic class MyService : IMyService\n{\n    public string ReverseString(string input)\n    {\n        char[] array = input.ToCharArray();\n        Array.Reverse(array);\n        return new String(array);\n    }\n\n    public KeyValuePair<int, string>[] GetKeyValuePairs()\n    {\n        List<KeyValuePair<int, string>> list = new List<KeyValuePair<int, string>>();\n        list.Add(new KeyValuePair<int, string>(1, "One"));\n        list.Add(new KeyValuePair<int, string>(2, "Two"));\n        return list.ToArray();\n    }\n}