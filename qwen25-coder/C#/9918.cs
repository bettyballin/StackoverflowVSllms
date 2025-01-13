using System;\nusing System.Collections.Generic;\nusing System.Linq.Expressions;\n\nclass Program\n{\n    static void Main()\n    {\n        var variables = new Dictionary<string, bool>\n        {\n            { "A", true },\n            { "B", false },\n            { "C", true }\n        };\n\n        string expression = "(A && B) || (A && C) || (!B && C)";\n\n        Func<bool> func = CompileExpression(expression, variables);\n        bool result = func();\n\n        Console.WriteLine($"The result of the expression is: {result}");\n    }\n\n    static Func<bool> CompileExpression(string expr, Dictionary<string, bool> variables)\n    {\n        var parameterExpressions = new List<ParameterExpression>();\n        var variableReferences = new List<Expression>();\n\n        foreach (var key in variables.Keys)\n        {\n            var paramExpr = Expression.Parameter(typeof(bool), key);\n            parameterExpressions.Add(paramExpr);\n\n            // Create a dictionary lookup expression to replace key with value\n            var constantExpr = Expression.Constant(variables[key]);\n            variableReferences.Add(constantExpr);\n        }\n\n        // Parse the expression string into an Expression object\n        Expression body = null;\n        try\n        {\n            body = ExpressionTreeParser.ParseExpression(expr, parameterExpressions);\n        }\n        catch (Exception ex)\n        {\n            throw new InvalidOperationException("Invalid expression.", ex);\n        }\n\n        var lambdaExpression = Expression.Lambda<Func<bool>>(body);\n        return lambdaExpression.Compile();\n    }\n}\n\nclass ExpressionTreeParser\n{\n    public static Expression ParseExpression(string expr, List<ParameterExpression> paramExprs)\n    {\n        // Implement parsing logic here. This is a simplified example.\n        // You would need to properly tokenize and parse the expression string.\n\n        // This is just an illustrative placeholder:\n        // The actual parsing would involve handling different operators (&&, ||, !), parentheses, etc.\n        return Expression.Constant(expr); // Replace with actual parsed Expression\n    }\n}