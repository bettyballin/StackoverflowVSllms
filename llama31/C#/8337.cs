enum Age { Over18, Under18 };\n\nclass Program\n{\n    static void Main()\n    {\n        Age personAge = Age.Over18;\n\n        switch (personAge)\n        {\n            case Age.Over18:\n                Console.WriteLine("Person is over 18.");\n                break;\n            case Age.Under18:\n                Console.WriteLine("Person is under 18.");\n                break;\n        }\n    }\n}