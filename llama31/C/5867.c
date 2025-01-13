int even_odd_rule(Point *points, int n, Point test) {\n    int i, j, intersection_count = 0;\n    for (i = 0; i < n; i++) {\n        j = (i + 1) % n;\n        if (points[i].x <= test.x && points[j].x > test.x) {\n            if (points[i].y <= points[j].y) {\n                intersection_count += 1;\n            } else {\n                intersection_count -= 1;\n            }\n        } else if (points[i].x > test.x && points[j].x <= test.x) {\n            if (points[i].y >= points[j].y) {\n                intersection_count += 1;\n            } else {\n                intersection_count -= 1;\n            }\n        }\n    }\n    return intersection_count % 2;\n}