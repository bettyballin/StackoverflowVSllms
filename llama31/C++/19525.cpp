#include <cstdint>\n#include <vector>\n\nuint64_t fnv1a_hash(const std::vector<uint64_t>& addresses) {\n    const uint64_t prime = 0x100000001b3;\n    uint64_t hash = 0;\n\n    for (const auto& address : addresses) {\n        hash = (hash ^ address) * prime;\n    }\n\n    return hash;\n}