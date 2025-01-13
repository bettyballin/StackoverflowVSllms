SELECT\n    R.RoleName,\n    U.UserName,\n    C.Path\nFROM\n    ReportServer.dbo.Catalog C WITH (NOLOCK)    --Parent\n    JOIN\n    ReportServer.dbo.Policies P WITH (NOLOCK) ON C.PolicyID = P.PolicyID\n    JOIN\n    ReportServer.dbo.PolicyUserRole PUR WITH (NOLOCK) ON P.PolicyID = PUR.PolicyID \n    JOIN\n    ReportServer.dbo.Users U WITH (NOLOCK) ON PUR.UserID = U.UserID \n    JOIN\n    ReportServer.dbo.Roles R WITH (NOLOCK) ON PUR.RoleID = R.RoleID\nWHERE\n    C.Type = 1 