public override void FeatureActivated(SPFeatureReceiverProperties properties)\n{\n    SPSite site = properties.Feature.Parent as SPSite;\n    if (site != null)\n    {\n        SPWeb web = site.RootWeb;\n        if (web != null)\n        {\n            SPRoleDefinition roleDefinition = web.RoleDefinitions.GetByType(SPRoleType.Contributor);\n            SPRoleAssignment roleAssignment = new SPRoleAssignment(web.AssociatedOwnerGroup);\n            roleAssignment.RoleDefinitionBindings.Remove(roleDefinition);\n            web.RoleAssignments.Add(roleAssignment);\n            web.Update();\n        }\n    }\n}