[HttpPut]\npublic ActionResult Update(int id, MyModel model)\n{\n    // Update logic here\n    return Json(new { message = "Updated successfully" });\n}\n\n[HttpDelete]\npublic ActionResult Delete(int id)\n{\n    // Delete logic here\n    return Json(new { message = "Deleted successfully" });\n}