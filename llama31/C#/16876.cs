int squareExp2 = iSquare * iSquare;\nint square = iSquare;\n\nfor (int j = 0; j < squareExp2; j++)\n{\n    for (int i = 0; i < squareExp2; i++)\n    {\n        int box = j * squareExp2 + i;\n        gridbox[box] = (j / square) * squareExp2 * square + (j % square) * square + (i / square) * squareExp2 + (i % square);\n        gridbox1[gridbox[box]] = (j / square) * squareExp2 * square + ((j % square) * square) * square;\n    }\n}