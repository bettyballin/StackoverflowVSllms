[AcceptVerbs(HttpVerbs.Post)]\npublic ActionResult SaveImage(string file, string fileName)\n{\n    byte[] imageBytes = Convert.FromBase64String(file);\n    string filePath = Server.MapPath("~/images/" + fileName);\n    System.IO.File.WriteAllBytes(filePath, imageBytes);\n    return PartialView("ImageSaved");\n}