double findMaxRange(double* data, int size, int windowSize) {\n    double maxRange = 0.0;\n    double minVal = data[0];\n    double maxVal = data[0];\n    int minIndex = 0;\n    int maxIndex = 0;\n\n    for (int i = 1; i < size; i++) {\n        if (data[i] < minVal) {\n            minVal = data[i];\n            minIndex = i;\n        }\n        if (data[i] > maxVal) {\n            maxVal = data[i];\n            maxIndex = i;\n        }\n\n        if (i - minIndex >= windowSize) {\n            // backtrack to find new min\n            minVal = data[i - windowSize + 1];\n            for (int j = i - windowSize + 2; j <= i; j++) {\n                if (data[j] < minVal) {\n                    minVal = data[j];\n                    minIndex = j;\n                }\n            }\n        }\n\n        if (i - maxIndex >= windowSize) {\n            // backtrack to find new max\n            maxVal = data[i - windowSize + 1];\n            for (int j = i - windowSize + 2; j <= i; j++) {\n                if (data[j] > maxVal) {\n                    maxVal = data[j];\n                    maxIndex = j;\n                }\n            }\n        }\n\n        if (maxIndex - minIndex <= windowSize) {\n            maxRange = std::max(maxRange, maxVal - minVal);\n        }\n    }\n\n    return maxRange;\n}