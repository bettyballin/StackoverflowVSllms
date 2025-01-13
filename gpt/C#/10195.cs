public override void ItemAdded(SPItemEventProperties properties)\n{\n    base.ItemAdded(properties);\n    BreakRoleInheritance(properties.ListItem, true);\n    SetItemPermissions(properties.ListItem);\n}\n\npublic override void ItemUpdated(SPItemEventProperties properties)\n{\n    base.ItemUpdated(properties);\n    SetItemPermissions(properties.ListItem);\n}\n\nprivate void BreakRoleInheritance(SPListItem listItem, bool copyRoleAssignments)\n{\n    listItem.BreakRoleInheritance(copyRoleAssignments);\n    listItem.Update();\n}\n\nprivate void SetItemPermissions(SPListItem listItem)\n{\n    var assignedToField = listItem["Assigned To"] as SPFieldUserValue;\n    if (assignedToField != null)\n    {\n        var assignedToUser = assignedToField.User;\n        listItem.RoleAssignments.RemoveAll();\n\n        SPRoleDefinition roleDefinition = listItem.ParentList.ParentWeb.RoleDefinitions.GetByType(SPRoleType.Contributor);\n        SPRoleAssignment roleAssignment = new SPRoleAssignment(assignedToUser);\n        roleAssignment.RoleDefinitionBindings.Add(roleDefinition);\n        listItem.RoleAssignments.Add(roleAssignment);\n        listItem.Update();\n    }\n}