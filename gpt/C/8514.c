start_color();\n    init_pair(1, COLOR_RED, COLOR_BLACK);\n    attron(COLOR_PAIR(1));\n    printw("Red text on black background");\n    attroff(COLOR_PAIR(1));