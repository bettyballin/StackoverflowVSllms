using System.Text.RegularExpressions;\n\n// ...\n\nstring script = scr.Script(opt);\n\n// Replace the date format in the comments with a custom format\nscript = Regex.Replace(script, @"/\*.*?Script Date: (\d{1,2}/\d{1,2}/\d{4}).*?\*/", \n    match => match.Value.Replace(match.Groups[1].Value, DateTime.Now.ToString("dd/MM/yyyy")));\n\n// Save the modified script to a file\nFile.WriteAllText("script.sql", script);