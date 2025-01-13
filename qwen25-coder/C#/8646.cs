[HttpPost]\npublic ActionResult UpdateStep2(FormCollection form)\n{\n    var factory = SessionFactoryCreator.Create();\n\n    using (var session = factory.OpenSession())\n    {\n        Recipe recipe = GetRecipe(session, Convert.ToInt32(form["RecipeID"]));\n\n        Ingredient ingredient = new Ingredient();\n        ingredient.UpdateFromForm(form);\n        ingredient.Validate(ViewData);\n\n        if (ViewData.ModelState.IsValid)\n        {\n            recipe.Ingredients.Add(ingredient);\n            session.Save(recipe);\n            return PartialView("IngredientsListControl", recipe.Ingredients);\n        }\n\n        // Return the partial view with errors if ModelState is not valid\n        return PartialView("IngredientsListControl", recipe.Ingredients);\n    }\n}