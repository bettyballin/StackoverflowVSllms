// Board.h\nclass Pair {\npublic:\n    float x;\n    float y;\n    Pair(float x, float y) : x(x), y(y) {}\n};\n\nclass Board{\npublic:\n    enum PhysicsResult{ BOUNCE, OUT_OF_BOUNDS_TOP, OUT_OF_BOUNDS_BOTTOM, CONTINUE };\n    //World constants\n    const static float Height;\n    const static float Width;\n    const static float PaddleWidth;\n    const static float BallRadius;\n    const static float BounceDistance;\n\n    //World Objects\n    Pair corner0;\n    Pair corner1;\n    Pair corner2;\n    Pair corner3;\n    Pair left_wall[2];\n    Pair right_wall[2];\n    Pair top_wall[2];\n    Pair bottom_wall[2];\n\n    Board();\n};\n\n// Board.cpp\n#include "Board.h"\n\nconst float Board::Height = 500;\nconst float Board::Width = 300;\nconst float Board::PaddleWidth = Board::Width / 15.0f;\nconst float Board::BallRadius = 5;\nconst float Board::BounceDistance = 1.5;\n\nBoard::Board() :\n    corner0(0, 0),\n    corner1(0, Height),\n    corner2(Width, Height),\n    corner3(Width, 0),\n    left_wall{corner0, corner1},\n    right_wall{corner3, corner2},\n    top_wall{corner1, corner2},\n    bottom_wall{corner0, corner3}\n{}