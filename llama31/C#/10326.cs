SPListItem item = // get the item you want to manage permissions for\n\n// Break role inheritance\nitem.BreakRoleInheritance(true);\n\n// Add a new role assignment\nSPRoleAssignment roleAssignment = new SPRoleAssignment("DOMAIN\\User", "Full Control");\nitem.RoleAssignments.Add(roleAssignment);\n\n// Remove an existing role assignment\nSPRoleAssignment existingAssignment = item.RoleAssignments.GetAssignmentByUser("DOMAIN\\OtherUser");\nif (existingAssignment != null)\n{\n    item.RoleAssignments.Remove(existingAssignment);\n}\n\n// Save the changes\nitem.Update();