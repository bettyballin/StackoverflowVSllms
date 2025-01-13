// Inside your Controller\n[HttpPost]\npublic ActionResult UploadFiles()\n{\n    if (Request.Files.Count > 0)\n    {\n        try\n        {\n            //Loop through all files uploaded.\n            for (int i = 0; i < Request.Files.Count; i++)\n            {\n                HttpPostedFileBase file = Request.Files[i];\n\n                if (file != null && file.ContentLength > 0)\n                {\n                    string fileName = Path.GetFileName(file.FileName);\n                    string path = Path.Combine(Server.MapPath("~/UploadedFiles"), fileName);\n                    file.SaveAs(path);\n                }\n            }\n\n            return Json(new { success = true, message = "File uploaded successfully!" });\n        }\n        catch (Exception ex)\n        {\n            return Json(new { success = false, message = ex.Message });\n        }\n    }\n\n    return Json(new { success = false, message = "No files were uploaded." });\n}