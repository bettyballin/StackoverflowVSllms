# Create a directory for the build\nmkdir gcc-build-arm && cd gcc-build-arm\n\n# Configure the GCC source\n../gcc/configure --target=arm-none-eabi \\n                  --prefix=/path/to/install/arm-cross \\n                  --without-headers \\n                  --enable-languages=c,c++ \\n                  --disable-shared \\n                  --with-newlib \\n                  --with-gnu-as --with-gnu-ld\n\n# Build the compiler and install it\nmake\nmake install