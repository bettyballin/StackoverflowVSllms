Dim s as string = "1, 2, '1,233,333', '8,444,555'";\n        Dim r as Regex = new Regex(",\s");\n        Dim re() as string = r.Split(s);