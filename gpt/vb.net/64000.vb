CurrentPage.Roles.Load()\nCurrentUser.Roles.Load()\nDim Allow As Boolean = CurrentPage.Roles.Any(Function(pageRole) CurrentUser.Roles.Any(Function(userRole) userRole.Id = pageRole.Id))