public static bool UserHasPermission(string userName, string permissionName)\n   {\n       using (SqlConnection conn = new SqlConnection("your_connection_string"))\n       {\n           string query = @"\n               SELECT COUNT(*)\n               FROM Users u\n               JOIN UserRoles ur ON u.UserID = ur.UserID\n               JOIN RolePermissions rp ON ur.RoleID = rp.RoleID\n               JOIN Permissions p ON rp.PermissionID = p.PermissionID\n               WHERE u.UserName = @UserName AND p.PermissionName = @PermissionName";\n           SqlCommand cmd = new SqlCommand(query, conn);\n           cmd.Parameters.AddWithValue("@UserName", userName);\n           cmd.Parameters.AddWithValue("@PermissionName", permissionName);\n           conn.Open();\n           int count = (int)cmd.ExecuteScalar();\n           return count > 0;\n       }\n   }