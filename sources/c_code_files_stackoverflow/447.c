#ifndef _WIN32
#define DllExport __attribute__((visibility("default")))
#else
#define DllExport __declspec(dllexport)
#endif

int DllExport Foo1( int a ) {
  // implementation
}

int DllExport Foo2( int a, int b ) {
  // implementation
}