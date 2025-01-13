#include <lua.h>\n#include <lauxlib.h>\n#include <lualib.h>\n\n// Function to store a Lua function and return its reference\nint store_lua_function(lua_State *L) {\n    // Ensure the function is on top of the stack\n    if (!lua_isfunction(L, -1)) {\n        lua_pushstring(L, "Expected a function");\n        lua_error(L);\n    }\n\n    // Create a reference to the function\n    int ref = luaL_ref(L, LUA_REGISTRYINDEX);\n\n    // Return the reference\n    lua_pushinteger(L, ref);\n    return 1;\n}\n\n// Function to call a stored Lua function using its reference\nint call_stored_function(lua_State *L) {\n    // Get the reference from the arguments\n    int ref = luaL_checkinteger(L, 1);\n\n    // Push the function from the registry onto the stack\n    lua_rawgeti(L, LUA_REGISTRYINDEX, ref);\n\n    // Check if it's a function\n    if (!lua_isfunction(L, -1)) {\n        lua_pushstring(L, "Reference does not point to a function");\n        lua_error(L);\n    }\n\n    // Call the function (assuming no arguments and no return values for simplicity)\n    if (lua_pcall(L, 0, 0, 0) != LUA_OK) {\n        lua_error(L);\n    }\n\n    return 0;\n}\n\nint main(void) {\n    lua_State *L = luaL_newstate();\n    luaL_openlibs(L);\n\n    // Load and run a Lua script that defines a function\n    luaL_dostring(L, "function my_func() print('Hello from Lua!') end");\n\n    // Push the function onto the stack\n    lua_getglobal(L, "my_func");\n\n    // Store the function and get its reference\n    store_lua_function(L);\n    int ref = lua_tointeger(L, -1);\n    lua_pop(L, 1);\n\n    // Call the stored function using its reference\n    lua_pushinteger(L, ref);\n    call_stored_function(L);\n\n    lua_close(L);\n    return 0;\n}