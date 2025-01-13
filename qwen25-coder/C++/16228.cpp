#include "skia/include/core/SkCanvas.h"\n#include "skia/include/core/SkSurface.h"\n\nvoid DrawOnMFCDeviceContext(CDC* pDC, int width, int height) {\n    SkImageInfo info = SkImageInfo::Make(width, height, kBGRA_8888_SkColorType, kOpaque_SkAlphaType);\n    sk_sp<SkSurface> surface = SkSurfaces::MakeRaster(info);\n    \n    if (!surface) return;\n\n    SkCanvas* canvas = surface->getCanvas();\n\n    // Draw something using the Skia API\n    canvas->clear(SK_ColorWHITE);\n\n    SkPaint paint;\n    paint.setColor(SK_ColorBLUE);\n    paint.setStyle(SkPaint::Style::kStroke_Style);\n    canvas->drawLine(0, 0, width, height, paint);\n\n    // Copy the rendered image onto the MFC device context.\n    BITMAPINFO bmi = {sizeof(BITMAPINFOHEADER)};\n    bmi.bmiHeader.biWidth = -width; // negative for top-down bitmap\n    bmi.bmiHeader.biHeight = height;\n    bmi.bmiHeader.biPlanes = 1;\n    bmi.bmiHeader.biBitCount = 32;\n    bmi.bmiHeader.biCompression = BI_RGB;\n\n    const void* pixels = surface->peekPixels()->addr();\n    ::SetDIBitsToDevice(pDC->GetSafeHdc(), 0, 0, width, height, 0, 0, 0, height, pixels, &bmi, DIB_RGB_COLORS);\n}