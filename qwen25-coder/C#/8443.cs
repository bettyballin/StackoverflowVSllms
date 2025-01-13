using System.ComponentModel;\n\npublic class FloorList : BindingList<Floor>\n{\n    protected override void OnAddingNew(AddingNewEventArgs e)\n    {\n        // Optionally handle new item initialization.\n        base.OnAddingNew(e);\n    }\n\n    protected override void InsertItem(int index, Floor item)\n    {\n        base.InsertItem(index, item);\n        UpdateElevations();\n    }\n\n    protected override void RemoveItem(int index)\n    {\n        base.RemoveItem(index);\n        UpdateElevations();\n    }\n\n    protected override void SetItem(int index, Floor item)\n    {\n        base.SetItem(index, item);\n        UpdateElevations();\n    }\n\n    private void UpdateElevations()\n    {\n        int runningTotal = 0;\n        foreach (var floor in this)\n        {\n            floor.Elevation = runningTotal;\n            runningTotal += floor.Height;\n        }\n    }\n}