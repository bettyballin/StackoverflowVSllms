// Ensure the graph is in a stopped state before attempting new media playback\nif (mMC) {\n    mMC->Stop();\n\n    // Wait until the graph stops before changing media.\n    WAIT_FOR_STATE_CHANGE(mMS, State_Stopped);\n}\n\n// Release the source filter, if it exists, so we can replace it.\nIBaseFilter *pSource = NULL;\nif (SUCCEEDED(mpGB->FindFilterByName(L"SOURCE", &pSource)) && pSource) {\n    mpGB->RemoveFilter(pSource);\n    pSource->Release();\n    pSource = NULL;\n}\n\n// Re-render the file\nhr = RenderFileToVideoRenderer(mpGB, mPlayPath.c_str(), FALSE);\nif (FAILED(hr)) {\n    return hr; // Handle failure\n}\n\n// QueryInterface for DirectShow interfaces if necessary, re-query after changing media\nhr = mpGB->QueryInterface(&mMC);\nif (FAILED(hr)) {\n    return hr; // Handle failure\n}\n// Repeat similar queries...\n\n// Run the graph to play the new media file\nhr = mMC->Run();\nif (FAILED(hr)) {\n    return hr; // Handle failure\n}\n\nmState = Running;