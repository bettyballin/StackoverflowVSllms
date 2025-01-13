var principal = (ClaimsPrincipal)Thread.CurrentPrincipal;\nvar entityPermission = (EntityPermissionAttribute)MethodInfo.GetCurrentMethod().GetCustomAttributes(typeof(EntityPermissionAttribute), false).FirstOrDefault();\n\nif (entityPermission != null)\n{\n    var claim = principal.Claims.FirstOrDefault(c => c.Type == "EntityPermission" && c.Value == entityPermission.EntityName + ":" + entityPermission.Permission);\n    if (claim == null)\n    {\n        throw new UnauthorizedAccessException("Access denied");\n    }\n}