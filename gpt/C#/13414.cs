using System;\nusing System.Collections.Generic;\nusing System.Linq.Expressions;\n\nclass Program\n{\n    static void Main()\n    {\n        string input = "( [PART3]function1() AND [PART4]function7() ) OR [PART2]function90()";\n\n        Dictionary<string, Func<bool>> functions = new Dictionary<string, Func<bool>>\n        {\n            { "PART3function1", () => true },\n            { "PART4function7", () => false },\n            { "PART2function90", () => true }\n        };\n\n        bool result = EvaluateExpression(input, functions);\n        Console.WriteLine("Final Result: " + result);\n    }\n\n    static bool EvaluateExpression(string input, Dictionary<string, Func<bool>> functions)\n    {\n        var tokens = Tokenize(input);\n        var expr = Parse(tokens, functions);\n        var lambda = Expression.Lambda<Func<bool>>(expr).Compile();\n        return lambda();\n    }\n\n    static List<string> Tokenize(string input)\n    {\n        return input\n            .Replace("(", " ( ")\n            .Replace(")", " ) ")\n            .Replace("AND", " AND ")\n            .Replace("OR", " OR ")\n            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)\n            .ToList();\n    }\n\n    static Expression Parse(List<string> tokens, Dictionary<string, Func<bool>> functions)\n    {\n        Stack<Expression> exprStack = new Stack<Expression>();\n        Stack<string> opStack = new Stack<string>();\n\n        while (tokens.Count > 0)\n        {\n            string token = tokens[0];\n            tokens.RemoveAt(0);\n\n            if (token == "(")\n            {\n                opStack.Push(token);\n            }\n            else if (token == ")")\n            {\n                while (opStack.Peek() != "(")\n                {\n                    exprStack.Push(ApplyOperator(opStack.Pop(), exprStack.Pop(), exprStack.Pop()));\n                }\n                opStack.Pop();\n            }\n            else if (token == "AND" || token == "OR")\n            {\n                while (opStack.Count > 0 && Precedence(opStack.Peek()) >= Precedence(token))\n                {\n                    exprStack.Push(ApplyOperator(opStack.Pop(), exprStack.Pop(), exprStack.Pop()));\n                }\n                opStack.Push(token);\n            }\n            else\n            {\n                string functionName = token.Replace("[", "").Replace("]", "").Replace("()", "");\n                var functionCall = Expression.Invoke(Expression.Constant(functions[functionName]));\n                exprStack.Push(functionCall);\n            }\n        }\n\n        while (opStack.Count > 0)\n        {\n            exprStack.Push(ApplyOperator(opStack.Pop(), exprStack.Pop(), exprStack.Pop()));\n        }\n\n        return exprStack.Pop();\n    }\n\n    static Expression ApplyOperator(string op, Expression right, Expression left)\n    {\n        if (op == "AND")\n        {\n            return Expression.AndAlso(left, right);\n        }\n        else if (op == "OR")\n        {\n            return Expression.OrElse(left, right);\n        }\n        throw new InvalidOperationException("Invalid operator");\n    }\n\n    static int Precedence(string op)\n    {\n        switch (op)\n        {\n            case "OR": return 1;\n            case "AND": return 2;\n            default: return 0;\n        }\n    }\n}