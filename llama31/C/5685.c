// Assuming you have a Lua state (L) and a function on the stack\nlua_State* L = ...;\nlua_pushfunction(L, ...); // push the function onto the stack\n\n// Create a reference to the function\nint ref = luaL_ref(L, LUA_REGISTRYINDEX);\n\n// Store the reference for later use\n// e.g. in a struct or array