public class PermissionAttribute : AuthorizeAttribute\n   {\n       private readonly string _permission;\n\n       public PermissionAttribute(string permission)\n       {\n           _permission = permission;\n       }\n\n       protected override bool IsAuthorized(HttpActionContext actionContext)\n       {\n           var userId = actionContext.RequestContext.Principal.Identity.GetUserId();\n           var tenantId = GetTenantIdFromContext(actionContext);\n\n           using (var context = new ApplicationDbContext())\n           {\n               var userRoles = context.UserRoles\n                   .Where(ur => ur.UserId == userId && ur.Role.TenantId == tenantId)\n                   .Select(ur => ur.RoleId).ToList();\n\n               var hasPermission = context.RolePermissions\n                   .Any(rp => userRoles.Contains(rp.RoleId) && rp.Permission.PermissionName == _permission);\n\n               return hasPermission;\n           }\n       }\n\n       private int GetTenantIdFromContext(HttpActionContext actionContext)\n       {\n           // Retrieve tenant ID from the request context\n           // This can be done through various means such as subdomain, headers, etc.\n           return 0; // Placeholder for actual implementation\n       }\n   }