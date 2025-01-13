public ActionResult GeneratePdf(int id)\n    {\n        var letter = GetLetterById(id); // Method to fetch data for the letter\n        return new Rotativa.MVC.ActionAsPdf("GenerateLetter", new { id })\n        {\n            FileName = "letter.pdf"\n        };\n    }