../configure --prefix=/your/custom/prefix \\n                --host=i386-linux-gnu \\n                --build=x86_64-linux-gnu \\n                CC_FOR_TARGET=$HOME/toolchain/bin/i386-linux-gnu-gcc \\n                CXX_FOR_TARGET=$HOME/toolchain/bin/i386-linux-gnu-g++