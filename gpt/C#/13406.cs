using System;\nusing System.Collections.Generic;\nusing Newtonsoft.Json;\n\npublic class Algorithm\n{\n    public List<ConditionResult> algorithm { get; set; }\n    public string defaultResult { get; set; }\n}\n\npublic class ConditionResult\n{\n    public string condition { get; set; }\n    public string result { get; set; }\n}\n\npublic class AlgorithmInterpreter\n{\n    public string InterpretAlgorithm(int inputParameter1, int inputParameter2, string jsonAlgorithm)\n    {\n        var algorithm = JsonConvert.DeserializeObject<Algorithm>(jsonAlgorithm);\n\n        foreach (var item in algorithm.algorithm)\n        {\n            if (EvaluateCondition(item.condition, inputParameter1, inputParameter2))\n            {\n                return EvaluateResult(item.result, inputParameter1, inputParameter2);\n            }\n        }\n\n        return algorithm.defaultResult;\n    }\n\n    private bool EvaluateCondition(string condition, int inputParameter1, int inputParameter2)\n    {\n        if (condition == "inputParameter1 == 1")\n        {\n            return inputParameter1 == 1;\n        }\n        else if (condition == "inputParameter2 == 5")\n        {\n            return inputParameter2 == 5;\n        }\n\n        return false;\n    }\n\n    private string EvaluateResult(string result, int inputParameter1, int inputParameter2)\n    {\n        if (result == "one")\n        {\n            return "one";\n        }\n        else if (result == "five + inputParameter1")\n        {\n            return "five" + inputParameter1;\n        }\n\n        return "not found";\n    }\n}