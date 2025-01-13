using System.Windows.Automation;\n\n// Get the element you want to right-click on\nAutomationElement element = ...;\n\n// Simulate a right-click on the element\nMouse.Click(element, MouseButtons.Right);\n\n// Get the context menu\nAutomationElement contextMenu = element.FindFirst(\n    TreeScope.Descendants,\n    new PropertyCondition(AutomationElement.ClassNameProperty, "ContextMenu")\n);\n\n// Find the menu item you want to select\nAutomationElement menuItem = contextMenu.FindFirst(\n    TreeScope.Descendants,\n    new PropertyCondition(AutomationElement.NameProperty, "Your Menu Item Name")\n);\n\n// Select the menu item\nmenuItem.Invoke();