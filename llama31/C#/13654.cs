public class MyBusinessObjectCollection : IBindingList\n{\n    private List<MyBusinessObject> _list;\n\n    public MyBusinessObjectCollection(List<MyBusinessObject> list)\n    {\n        _list = list;\n    }\n\n    public void Sort(PropertyDescriptor property, ListSortDirection direction)\n    {\n        // Implement sorting logic here\n    }\n\n    // ...\n}