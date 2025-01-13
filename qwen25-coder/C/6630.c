// Ensure you push the matrix before drawing background and text\nglMatrixMode(GL_PROJECTION);\nglPushMatrix();\n// Setup your projection here\n\nglMatrixMode(GL_MODELVIEW);\nglPushMatrix();\n// Setup your modelview for drawing the quad\n// Draw your gradient background here\n\n// Now for the text, ensure it's in its own matrix state if needed\nglPushMatrix();\n// Adjust or set new modelview matrices as necessary if required to position text correctly\n// Set raster position and draw text\nglRasterPos3d(X, Y, Z);\nglListBase(FontID - 32);\nDim B() As Byte\nB = StrConv(TextString, vbFromUnicode)\nglCallLists(Len(TextString), GL_UNSIGNED_BYTE, B(0))\nglPopMatrix(); // Pop for text matrix\n\n// Finish with your other drawing operations as needed\n\nglPopMatrix(); // Pop for initial modelview setup\nglMatrixMode(GL_PROJECTION);\nglPopMatrix(); // Pop for projection setup