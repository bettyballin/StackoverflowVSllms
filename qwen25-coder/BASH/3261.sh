patchelf --set-interpreter /path/to/newglibc/ld-2.3.3.so --replace-needed libc.so.6 /path/to/newglibc/libc.so.6 myapp\n   patchelf --set-interpreter /path/to/newglibc/ld-2.3.3.so --replace-needed libpthread.so.0 /path/to/newglibc/libpthread.so.0 myapp