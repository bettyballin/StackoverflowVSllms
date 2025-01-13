// In DLL A\n   void* MyAlloc(size_t size) {\n       return malloc(size);\n   }\n\n   void MyFree(void* ptr) {\n       free(ptr);\n   }\n\n   // In DLL B or main application\n   extern void* MyAlloc(size_t size);\n   extern void MyFree(void* ptr);\n\n   void UseMemory() {\n       void* mem = MyAlloc(1024);\n       // Use memory\n       MyFree(mem);\n   }