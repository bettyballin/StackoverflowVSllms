QFile file("example.txt");\nif (file.open(QIODevice::ReadOnly)) {\n    QByteArray content = file.readAll();\n    file.close();\n\n    QList<QByteArray> lines = content.split('\n');\n    foreach (const QByteArray &line, lines) {\n        // process the line\n    }\n}