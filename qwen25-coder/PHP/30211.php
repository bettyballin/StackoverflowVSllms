// Example setting through code, usually done via UI\n     $group_admin_role = user_role_load_by_name('GroupAdmin');\n     user_role_grant_permissions($group_admin_role->id(), ['create group', 'edit any group_content', 'delete any group_content']);