g++ -o build/bin/myapp build/bin/myapp.o -Wl,-rpath,/path/to/lib -L/path/to/lib -Wl,--no-as-needed -lmylib