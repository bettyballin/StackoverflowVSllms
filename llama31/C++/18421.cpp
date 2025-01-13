class Board{\npublic:\n    enum PhysicsResult{ BOUNCE, OUT_OF_BOUNDS_TOP, OUT_OF_BOUNDS_BOTTOM, CONTINUE };\n\n    //World constants\n    static const float Height;\n    static const float Width;\n    static const float PaddleWidth;\n    static const float BallRadius;\n    static const float BounceDistance;\n\n    //World Objects\n    Ball ball;\n    Paddle paddle1;\n    Paddle paddle2;\n\n    static const Pair corners[4];\n    static const Pair left_wall[2];\n    static const Pair right_wall[2];\n    static const Pair top_wall[2];\n    static const Pair bottom_wall[2];\n};\n\nconst float Board::Height = 500;\nconst float Board::Width = 300;\nconst float Board::PaddleWidth = Board::Width / 15;\nconst float Board::BallRadius = 5;\nconst float Board::BounceDistance = 1.5;\n\nconst Pair Board::corners[4] = {Pair(0, 0), Pair(0, Board::Height), Pair(Board::Width, Board::Height), Pair(Board::Width, 0)};\nconst Pair Board::left_wall[2]   = {Board::corners[0], Board::corners[1]};\nconst Pair Board::right_wall[2]  = {Board::corners[3], Board::corners[2]};\nconst Pair Board::top_wall[2]    = {Board::corners[1], Board::corners[2]};\nconst Pair Board::bottom_wall[2] = {Board::corners[0], Board::corners[3]};