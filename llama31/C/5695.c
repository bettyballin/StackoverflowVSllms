#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n#include <ctype.h>\n\n// Define operator precedence\n#define PRECEDENCE_PLUS 1\n#define PRECEDENCE_MINUS 1\n#define PRECEDENCE_MUL 2\n#define PRECEDENCE_DIV 2\n\n// Define operator types\n#define OPERATOR_PLUS 1\n#define OPERATOR_MINUS 2\n#define OPERATOR_MUL 3\n#define OPERATOR_DIV 4\n\n// Define token types\n#define TOKEN_NUMBER 1\n#define TOKEN_OPERATOR 2\n#define TOKEN_LPAREN 3\n#define TOKEN_RPAREN 4\n\n// Define a token structure\ntypedef struct Token {\n    int type;\n    double value;\n    int operator;\n} Token;\n\n// Define a function to get the precedence of an operator\nint getPrecedence(int operator) {\n    switch (operator) {\n        case OPERATOR_PLUS:\n        case OPERATOR_MINUS:\n            return PRECEDENCE_PLUS;\n        case OPERATOR_MUL:\n        case OPERATOR_DIV:\n            return PRECEDENCE_MUL;\n        default:\n            return 0;\n    }\n}\n\n// Define a function to parse the input expression\nvoid parseExpression(char* input) {\n    Token outputQueue[100];\n    int outputIndex = 0;\n    Token operatorStack[100];\n    int operatorIndex = 0;\n\n    // Tokenize the input expression\n    int pos = 0;\n    while (input[pos] != '\0') {\n        if (isdigit(input[pos])) {\n            // Read a number\n            double value = 0;\n            while (isdigit(input[pos])) {\n                value = value * 10 + (input[pos++] - '0');\n            }\n            outputQueue[outputIndex].type = TOKEN_NUMBER;\n            outputQueue[outputIndex].value = value;\n            outputIndex++;\n        } else if (input[pos] == '+') {\n            // Read a plus operator\n            while (operatorIndex > 0 && getPrecedence(operatorStack[operatorIndex - 1].operator) >= PRECEDENCE_PLUS) {\n                outputQueue[outputIndex].type = TOKEN_OPERATOR;\n                outputQueue[outputIndex].operator = operatorStack[operatorIndex - 1].operator;\n                outputIndex++;\n                operatorIndex--;\n            }\n            operatorStack[operatorIndex].type = TOKEN_OPERATOR;\n            operatorStack[operatorIndex].operator = OPERATOR_PLUS;\n            operatorIndex++;\n            pos++;\n        } else if (input[pos] == '-') {\n            // Read a minus operator\n            while (operatorIndex > 0 && getPrecedence(operatorStack[operatorIndex - 1].operator) >= PRECEDENCE_MINUS) {\n                outputQueue[outputIndex].type = TOKEN_OPERATOR;\n                outputQueue[outputIndex].operator = operatorStack[operatorIndex - 1].operator;\n                outputIndex++;\n                operatorIndex--;\n            }\n            operatorStack[operatorIndex].type = TOKEN_OPERATOR;\n            operatorStack[operatorIndex].operator = OPERATOR_MINUS;\n            operatorIndex++;\n            pos++;\n        } else if (input[pos] == '*') {\n            // Read a multiplication operator\n            while (operatorIndex > 0 && getPrecedence(operatorStack[operatorIndex - 1].operator) >= PRECEDENCE_MUL) {\n                outputQueue[outputIndex].type = TOKEN_OPERATOR;\n                outputQueue[outputIndex].operator = operatorStack[operatorIndex - 1].operator;\n                outputIndex++;\n                operatorIndex--;\n            }\n            operatorStack[operatorIndex].type = TOKEN_OPERATOR;\n            operatorStack[operatorIndex].operator = OPERATOR_MUL;\n            operatorIndex++;\n            pos++;\n        } else if (input[pos] == '/') {\n            // Read a division operator\n            while (operatorIndex > 0 && getPrecedence(operatorStack[operatorIndex - 1].operator) >= PRECEDENCE_DIV) {\n                outputQueue[outputIndex].type = TOKEN_OPERATOR;\n                outputQueue[outputIndex].operator = operatorStack[operatorIndex - 1].operator;\n                outputIndex++;\n                operatorIndex--;\n            }\n            operatorStack[operatorIndex].type = TOKEN_OPERATOR;\n            operatorStack[operatorIndex].operator = OPERATOR_DIV;\n            operatorIndex++;\n            pos++;\n        } else if (input[pos] == '(') {\n            // Read a left parenthesis\n            operatorStack[operatorIndex].type = TOKEN_LPAREN;\n            operatorIndex++;\n            pos++;\n        } else if (input[pos] == ')') {\n            // Read a right parenthesis\n            while (operatorIndex > 0 && operatorStack[operatorIndex - 1].type != TOKEN_LPAREN) {\n                outputQueue[outputIndex].type = TOKEN_OPERATOR;\n                outputQueue[outputIndex].operator = operatorStack[operatorIndex - 1].operator;\n                outputIndex++;\n                operatorIndex--;\n            }\n            operatorIndex--;\n            pos++;\n        } else {\n            pos++;\n        }\n    }\n\n    // Pop any remaining operators from the operator stack\n    while (operatorIndex > 0) {\n        outputQueue[outputIndex].type = TOKEN_OPERATOR;\n        outputQueue[outputIndex].operator = operatorStack[operatorIndex - 1].operator;\n        outputIndex++;\n        operatorIndex--;\n    }\n\n    // Evaluate the output queue\n    double result = 0;\n    for (int i = 0; i < outputIndex; i++) {\n        if (outputQueue[i].type == TOKEN_NUMBER) {\n            result = outputQueue[i].value;\n        } else if (outputQueue[i].type == TOKEN_OPERATOR) {\n            switch (outputQueue[i].operator) {\n                case OPERATOR_PLUS:\n                    result += outputQueue[i + 1].value;\n                    i++;\n                    break;\n                case OPERATOR_MINUS:\n                    result -= outputQueue[i + 1].value;\n                    i++;\n                    break;\n                case OPERATOR_MUL:\n                    result *= outputQueue[i + 1].value;\n                    i++;\n                    break;\n                case OPERATOR_DIV:\n                    result /= outputQueue[i + 1].value;\n                    i++;\n                    break;\n            }\n        }\n    }\n\n    printf("Result: %f\n", result);\n}\n\nint main() {\n    char* input = "2+3*(42/13)";\n    parseExpression(input);\n    return 0;\n}