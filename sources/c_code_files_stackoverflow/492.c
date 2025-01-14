#include <tchar.h>
#include <windows.h>
#include <mmsystem.h>

int _tmain( int argc, wchar_t *argv[] )
{
    UINT deviceCount = waveInGetNumDevs();

    if ( deviceCount > 0 )
    {
        for ( int i = 0; i < deviceCount; i++ )
        {
            WAVEINCAPSW waveInCaps;

            waveInGetDevCapsW( i, &waveInCaps, sizeof( WAVEINCAPSW ) );

            // do some stuff with waveInCaps...
        }
    }

    return 0;
}