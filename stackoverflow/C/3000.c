/* C way */\nFILE *fp = fopen("text.bin", "rb"); /* note the b; this is a compound mode */\n\n/* C++ way */\nstd::ifstream ifs("test.txt", ios::in | ios::binary);