using System.ComponentModel;\nusing System.IO;\nusing System.Runtime.Serialization.Formatters.Binary;\n\npublic class ComboBoxSettingsManager\n{\n    public static BindingList<string> LoadComboBoxItems()\n    {\n        if (string.IsNullOrEmpty(My.Settings.ComboBoxDS)) return new BindingList<string>();\n        \n        var serializer = new BinaryFormatter();\n        using (var stream = new MemoryStream(Convert.FromBase64String(My.Settings.ComboBoxDS)))\n        {\n            return ((ComboBoxDataSource)serializer.Deserialize(stream)).Items;\n        }\n    }\n\n    public static void SaveComboBoxItems(BindingList<string> items)\n    {\n        var dataSource = new ComboBoxDataSource { Items = items };\n\n        var serializer = new BinaryFormatter();\n        using (var stream = new MemoryStream())\n        {\n            serializer.Serialize(stream, dataSource);\n            My.Settings.ComboBoxDS = Convert.ToBase64String(stream.ToArray());\n            My.Settings.Save();\n        }\n    }\n}