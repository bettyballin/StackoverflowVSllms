using (Ajax.BeginForm("Add Ingredient", "Recipes/UpdateStep2", new AjaxOptions { \n    UpdateTargetId = "ingredientlistdiv", \n    InsertionMode = InsertionMode.Replace \n}))\n{\n    // ...\n}