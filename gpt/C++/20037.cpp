class Header {\npublic:\n    int type;\n    int payloadLength;\n\n    char* GetPayload() {\n        return reinterpret_cast<char*>(this + 1);\n    }\n};\n\nclass Message : public Header {\n    // Payload data would be here\n};