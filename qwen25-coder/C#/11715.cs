public class CustomBindingList<T> : BindingList<T>\n{\n    protected virtual void MoveItem(int oldIndex, int newIndex)\n    {\n        T item = Items[oldIndex];\n        Items.RemoveAt(oldIndex);\n        Items.Insert(newIndex, item);\n\n        OnListChanged(new ListChangedEventArgs(ListChangedType.ItemMoved, newIndex, oldIndex));\n    }\n}