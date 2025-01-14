#include "redismodule.h"

RedisModuleType *RadixTree; /* Global type holding our radix tree instance */

int RadixInsert(RedisModuleCtx *ctx, const char *key, size_t keylen, void *data);
int RadixLookup(const char *key, uint64_t klen, void **privData);

int main() {
    // Initialize the Redis module
    if (RedisModule_Init(NULL) == REDISMODULE_ERR) {
        return 1;
    }

    // Register the radix tree type
    RadixTree = RedisModule_CreateType("RadixTree");
    if (RadixTree == NULL) {
        return 1;
    }

    // Register the insert and lookup functions
    RedisModule_CreateCommand(RadixTree, "radix.insert", RadixInsert, "write", 1, 1, 1);
    RedisModule_CreateCommand(RadixTree, "radix.lookup", RadixLookup, "readonly", 1, 1, 1);

    // Run the Redis module event loop
    RedisModule_Run();
    return 0;
}