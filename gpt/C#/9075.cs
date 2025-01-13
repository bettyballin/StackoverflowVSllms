public class MyObject\n{\n    public int MyProperty { get; set; }\n}\n\nList<MyObject> originalList = new List<MyObject>\n{\n    new MyObject { MyProperty = 1 },\n    new MyObject { MyProperty = 2 },\n    new MyObject { MyProperty = 3 },\n    new MyObject { MyProperty = 4 },\n    new MyObject { MyProperty = 5 }\n};\n\nList<MyObject> filteredList = new List<MyObject>();\nint filterValue = 3;\n\nforeach (MyObject obj in originalList)\n{\n    if (obj.MyProperty > filterValue)\n    {\n        filteredList.Add(obj);\n    }\n}\n\n// filteredList now contains objects where MyProperty > 3