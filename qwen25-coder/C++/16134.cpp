void CYourDialog::SetFixedWidthFont()\n{\n    // Create a new font with desired attributes\n    LOGFONT lf;\n    memset(&lf, 0, sizeof(LOGFONT));\n    lf.lfHeight = -MulDiv(8, GetDeviceCaps(CDC::FromHandle(::GetDC(NULL)), LOGPIXELSY, 72); // Height in logical units (e.g., 8 pt)\n    lf.lfWeight = FW_NORMAL;\n    lstrcpy(lf.lfFaceName, _T("Consolas")); // Use your preferred fixed-width font here\n\n    CFont fontFixedWidth;\n    if (!fontFixedWidth.CreateFontIndirect(&lf))\n        return; // Font creation failed\n\n    // Set the new font for the list control\n    m_yourListCtrl.SetFont(&fontFixedWidth);\n}