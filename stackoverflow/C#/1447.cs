foreach (ModelState state in ViewData.ModelState.Values)\n        foreach (ModelError error in state.Errors)\n          MyLog(error.ErrorMessage);