static Predicate<Car> ByYear(int year)\n{\n    return delegate(Car car)\n    {\n        return car.Year == year;\n    };\n}\n\nstatic void Main(string[] args)\n{\n    // yeah, this bit is C# 3.0, but ignore it - it's just setting up the list.\n    List<Car> list = new List<Car>\n    {\n        new Car { Year = 1940 },\n        new Car { Year = 1965 },\n        new Car { Year = 1973 },\n        new Car { Year = 1999 }\n    };\n    var car99 = list.Find(ByYear(1999));\n    var car65 = list.Find(ByYear(1965));\n\n    Console.WriteLine(car99.Year);\n    Console.WriteLine(car65.Year);\n}