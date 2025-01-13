private void DeleteGridCellContent(Grid grid, int row, int column)\n{\n    // Find the child element in the specified cell\n    UIElement elementToRemove = null;\n    foreach (UIElement element in grid.Children)\n    {\n        if (Grid.GetRow(element) == row && Grid.GetColumn(element) == column)\n        {\n            elementToRemove = element;\n            break;\n        }\n    }\n\n    // Remove the element if found\n    if (elementToRemove != null)\n    {\n        grid.Children.Remove(elementToRemove);\n    }\n}