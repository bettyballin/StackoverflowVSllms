QTimer::singleShot(0, [&]() {\n    QScrollBar *vScrollBar = scrolledWindow->verticalScrollBar();\n    vScrollBar->setValue(vScrollBar->maximum());\n});