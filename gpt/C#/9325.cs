public class ScriptMain : UserComponent\n{\n    private Dictionary<int, Tuple<string, string>> accountsDict;\n\n    public override void PreExecute()\n    {\n        base.PreExecute();\n        accountsDict = new Dictionary<int, Tuple<string, string>>();\n    }\n\n    public override void Input0_ProcessInputRow(Input0Buffer Row)\n    {\n        if (!Row.EndOfRowset)\n        {\n            accountsDict.Add(Row.AccountID, Tuple.Create(Row.LowerGroup, Row.UpperGroup));\n        }\n    }\n\n    public override void Input1_ProcessInputRow(Input1Buffer Row)\n    {\n        foreach (var account in accountsDict)\n        {\n            if (string.Compare(Row.GroupName, account.Value.Item1) >= 0 && string.Compare(Row.GroupName, account.Value.Item2) <= 0)\n            {\n                Output0Buffer.AddRow();\n                Output0Buffer.AccountID = account.Key;\n                Output0Buffer.Customer = Row.Customer;\n            }\n        }\n    }\n}