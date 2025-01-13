// Assuming you have a pointer to the IDropTarget object\nIDropTarget* pDropTarget = ...;\n\n// Define the POINTL structure with the current mouse coordinates\nPOINTL pt;\nGetCursorPos(&pt);\n\n// Call the DragEnter method manually\nHRESULT hr = pDropTarget->DragEnter(&pt, NULL, NULL, NULL, NULL);\nif (SUCCEEDED(hr)) {\n    // The DragEnter event was fired successfully\n}