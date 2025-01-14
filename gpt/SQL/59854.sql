SELECT \n    Links.LinkName, \n    Groups.GroupName, \n    COALESCE(SubGroup.SubGroupName, '') AS SubGroupName\nFROM \n    Links\nJOIN \n    Groups ON Links.GroupID = Groups.GroupID\nLEFT JOIN \n    SubGroup ON Links.SubGroupID = SubGroup.SubGroupID