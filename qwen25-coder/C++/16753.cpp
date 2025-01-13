#include <dlfcn.h>\n#include <memory>\n#include <vector>\n#include <string>\n\nusing FactoryCreator = BaseFactory*();\n\nstd::vector<std::unique_ptr<Base>> loadAndInstantiate() {\n    std::vector<std::string> libraryNames = {"libDerivedA.so", "libDerivedB.so"}; // Add your platform-specific naming\n    std::vector<std::unique_ptr<Base>> instances;\n\n    for (const auto& libName : libraryNames) {\n        void* handle = dlopen(libName.c_str(), RTLD_LAZY);\n        if (!handle) {\n            continue; // Library not found or cannot be loaded\n        }\n\n        FactoryCreator* createFactory = reinterpret_cast<FactoryCreator*>(dlsym(handle, "createDerivedAFactory"));\n        if (createFactory) {\n            BaseFactory* factory = createFactory();\n            instances.push_back(factory->createInstance());\n        } else {\n            dlclose(handle);\n        }\n    }\n\n    return instances;\n}