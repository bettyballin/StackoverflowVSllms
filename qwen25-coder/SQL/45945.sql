SELECT rp.roleid\nFROM role_permission rp\nWHERE rp.permissionid IN (YOUR_PERMISSION_ID_LIST)\nGROUP BY rp.roleid\nHAVING COUNT(DISTINCT rp.permissionid) = PERMISSION_COUNT\nAND NOT EXISTS (\n    SELECT 1 \n    FROM role_permission \n    WHERE roleid = rp.roleid \n    AND permissionid NOT IN (YOUR_PERMISSION_ID_LIST)\n);