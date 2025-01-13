private List<int> ShiftPath(List<int> oldPath, int shift)\n{\n    int pivotIndex = oldPath.IndexOf(shift);\n    if (pivotIndex == -1)\n    {\n        throw new ArgumentException("Shift element not found in the list");\n    }\n\n    List<int> newPath = new List<int>(oldPath.Count);\n\n    // Add elements from the start to the pivot index\n    for (int i = 0; i <= pivotIndex; i++)\n    {\n        newPath.Add(oldPath[i]);\n    }\n\n    // Add elements from the end to the pivot index + 1 in reverse order\n    for (int i = oldPath.Count - 1; i > pivotIndex; i--)\n    {\n        newPath.Add(oldPath[i]);\n    }\n\n    return newPath;\n}