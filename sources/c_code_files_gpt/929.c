#include <lua.h>
#include <lualib.h>
#include <lauxlib.h>
#include <stdio.h>  // For fprintf

void execute_lua_script(const char* script) {
    lua_State *L = luaL_newstate();
    luaL_openlibs(L);

    if (luaL_loadstring(L, script) || lua_pcall(L, 0, 0, 0)) {
        fprintf(stderr, "Error: %s\n", lua_tostring(L, -1));  // Added newline character
    }

    lua_close(L);
}

int main() {
    const char* script = "print('Hello from Lua')";
    execute_lua_script(script);
    return 0;
}