#include <iostream>\n#include <vector>\n#include <queue>\n\nusing namespace std;\n\nconst int MAX_X = 100;\nconst int MAX_Y = 100;\n\nbool is_valid(const vector<vector<bool>>& map, int x, int y) {\n    return x >= 0 && x < MAX_X && y >= 0 && y < MAX_Y && !map[x][y];\n}\n\npair<int, int> bfs(const vector<vector<bool>>& map, int x, int y) {\n    queue<pair<int, int>> q;\n    vector<vector<bool>> visited(MAX_X, vector<bool>(MAX_Y, false));\n    q.push({x, y});\n    visited[x][y] = true;\n    int furthest_x = x, furthest_y = y;\n    while (!q.empty()) {\n        int curr_x = q.front().first, curr_y = q.front().second;\n        q.pop();\n        for (int dx = -1; dx <= 1; dx++) {\n            for (int dy = -1; dy <= 1; dy++) {\n                if (abs(dx) + abs(dy) == 1) {\n                    int next_x = curr_x + dx, next_y = curr_y + dy;\n                    if (is_valid(map, next_x, next_y) && !visited[next_x][next_y]) {\n                        visited[next_x][next_y] = true;\n                        q.push({next_x, next_y});\n                        furthest_x = next_x, furthest_y = next_y;\n                    }\n                }\n            }\n        }\n    }\n    return {furthest_x, furthest_y};\n}\n\npair<pair<int, int>, pair<int, int>> furthest_pair(const vector<vector<bool>>& map) {\n    pair<int, int> point1 = bfs(map, 0, 0);\n    pair<int, int> point2 = bfs(map, point1.first, point1.second);\n    return {point1, point2};\n}