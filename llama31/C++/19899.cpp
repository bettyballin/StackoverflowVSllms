int main()\n{\n    Gdiplus::GdiplusStartupInput gdiplusStartupInput;\n    Gdiplus::GdiplusStartup(&gdiplusToken, &gdiplusStartupInput, NULL);\n\n    // Load and save the image\n    Gdiplus::Bitmap* pBitmap;\n    LoadImageFromDatabase(&pBitmap);\n    SaveImageToFile(pBitmap, L"C:\\path\\to\\image.jpg");\n\n    Gdiplus::GdiplusShutdown(gdiplusToken);\n    return 0;\n}