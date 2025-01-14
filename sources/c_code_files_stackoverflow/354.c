#include <windows.h>

// Assuming WrapperDllMain is declared elsewhere
extern int WrapperDllMain( HINSTANCE, HINSTANCE, LPSTR, int, void (*)() );

// Assuming user_main is declared elsewhere
extern void user_main();

int WinMain( HINSTANCE hInstance, HINSTANCE hPrev, LPSTR lpCmdLine, int nCmdShow )
{
    return WrapperDllMain( hInstance, hPrev, lpCmdLine, nCmdShow, &user_main );
}