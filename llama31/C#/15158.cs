var linkedList = new LinkedList<int>();\n\n// Add elements\nlinkedList.AddLast(1);\nlinkedList.AddLast(2);\nlinkedList.AddLast(3);\n\n// Enumerate elements\nforeach (var item in linkedList)\n{\n    Console.WriteLine(item);\n}\n\n// Clear elements\nlinkedList.Clear();