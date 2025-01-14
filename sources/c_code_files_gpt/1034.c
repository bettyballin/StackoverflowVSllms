#include <lua.h>
#include <lauxlib.h>
#include <lualib.h>

// Function to store a Lua function and return its reference
int store_lua_function(lua_State *L) {
    // Ensure the function is on top of the stack
    if (!lua_isfunction(L, -1)) {
        lua_pushstring(L, "Expected a function");
        lua_error(L);
    }

    // Create a reference to the function
    int ref = luaL_ref(L, LUA_REGISTRYINDEX);

    // Return the reference
    lua_pushinteger(L, ref);
    return 1;
}

// Function to call a stored Lua function using its reference
int call_stored_function(lua_State *L) {
    // Get the reference from the arguments
    int ref = luaL_checkinteger(L, 1);

    // Push the function from the registry onto the stack
    lua_rawgeti(L, LUA_REGISTRYINDEX, ref);

    // Check if it's a function
    if (!lua_isfunction(L, -1)) {
        lua_pushstring(L, "Reference does not point to a function");
        lua_error(L);
    }

    // Call the function (assuming no arguments and no return values for simplicity)
    if (lua_pcall(L, 0, 0, 0) != LUA_OK) {
        lua_error(L);
    }

    return 0;
}

int main(void) {
    lua_State *L = luaL_newstate();
    luaL_openlibs(L);

    // Load and run a Lua script that defines a function
    luaL_dostring(L, "function my_func() print('Hello from Lua!') end");

    // Push the function onto the stack
    lua_getglobal(L, "my_func");

    // Store the function and get its reference
    store_lua_function(L);
    int ref = lua_tointeger(L, -1);
    lua_pop(L, 1);

    // Call the stored function using its reference
    lua_pushinteger(L, ref);
    call_stored_function(L);

    lua_close(L);
    return 0;
}