[AcceptVerbs("POST")]\npublic ActionResult AddExercise(FormCollection form)\n{\n    // some save logic...\n\n    // Return a partial view or some HTML content to update the resultDiv\n    return PartialView("_ExercisePartialView");\n}