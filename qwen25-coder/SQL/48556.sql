-- Assuming you want to get all users with access to tblJob\n\nWITH RecursiveGroups AS (\n    SELECT GroupID, GroupID as OriginalGroupID\n    FROM tblGroup \n    WHERE GroupID IN (SELECT GroupID FROM tblGroupUser WHERE UserID = @UserID)\n\n    UNION ALL \n\n    SELECT gg.GroupID, rg.OriginalGroupID\n    FROM tblGroupGroup gg\n    INNER JOIN RecursiveGroups rg ON gg.ParentGroupID = rg.GroupID\n),\nUserAndGroupPermissions AS (\n    -- Get User Permissions directly for tblJob\n    SELECT p.SecuredID, AllowFlag, 1 as SourceType -- 1 indicates permission is for user\n    FROM tblPermission p \n    WHERE	p.SecurityObjectID = @UserID AND p.TableName = 'tblJob'\n    \n    UNION ALL\n\n    -- Get Group Permissions for tblJob through recursive group membership\n    SELECT p.SecuredID, AllowFlag, 2 as SourceType -- 2 indicates permission is from a group\n    FROM tblPermission p \n    INNER JOIN RecursiveGroups rg ON p.SecurityObjectID = rg.GroupID AND rg.SystemFlag <> 1 -- Exclude System groups if needed\n    WHERE p.TableName = 'tblJob'\n)\nSELECT SecuredID, AllowFlag\nFROM (\n    SELECT TOP(1) WITH TIES SecuredID, AllowFlag, SourceType\n    FROM UserAndGroupPermissions\n    ORDER BY SourceType DESC, CASE WHEN AllowFlag = 0 THEN 1 ELSE 2 END -- Ensures deny takes precedence and user permissions override group ones\n) x\nORDER BY SecuredID;