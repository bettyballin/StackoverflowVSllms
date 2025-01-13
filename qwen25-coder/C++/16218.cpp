// Assuming 'dc' is an existing CDC object\nHDC hdc = dc.GetSafeHdc();\n\n// Now you can use 'hdc' as needed\n// Don't forget to release the HDC if it was temporarily retrieved from a temporary CDC\nif (dc.IsTemporary())\n{\n    dc.ReleaseDC();\n}