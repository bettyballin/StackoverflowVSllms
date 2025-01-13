using Slugify;\n\nclass Program\n{\n    static void Main()\n    {\n        var slugHelper = new SlugHelper();\n        string input = "èòà ? . , ()";\n        string slug = slugHelper.GenerateSlug(input);\n\n        Console.WriteLine(slug); // Output: eoa\n    }\n}