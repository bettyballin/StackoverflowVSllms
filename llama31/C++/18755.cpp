// Example of SRP\nclass Logger {\npublic:\n    void log(const std::string& message);\n};\n\nclass Calculator {\npublic:\n    int calculate(int a, int b);\nprivate:\n    Logger logger_;\n};