int main(int argc, char **argv) {\n    QApplication app(argc, argv);\n\n    if (app.arguments().contains("--child-mode")) {\n        // Run the code that's prone to crashing\n        runCrashyCode();\n    } else {\n        // Run the main application code\n        runMainApplication();\n    }\n\n    return app.exec();\n}