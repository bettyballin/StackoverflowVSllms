char* Header::GetPayload()\n{\n    return ((char*) this) + sizeof(Header);\n}