void Lion::breed() {\n    breedTicks++;\n\n    if (2 == breedTicks) {  // Assuming this threshold is correct\n        int dx[] = {-1, 0, 1};     // Possible x direction offsets for 8-neighborhood\n        int dy[] = {-1, 0, 1};     // Possible y direction offsets\n        \n        for (int i = 0; i < 3*3 - 1; ++i) {    // Iterate excluding (0,0)\n            int nx = x + dx[i/3];\n            int ny = y + dy[i%3];\n\n            if (withinBounds(nx, ny) && !savanna->getAt(nx, ny)) {\n                new Lion(savanna, nx, ny);           // Create a new lion\n                return;\n            }\n        }\n\n        breedTicks = 0;            // Reset breeding timer if no adjacent space was found\n    }\n}