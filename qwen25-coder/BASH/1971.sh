CXX=g++\nCXXFLAGS=-Wall -g\nLDFLAGS=-llog4cplus # Links against log4cplus library\n\nmain: main.cpp\n        $(CXX) $(CXXFLAGS) $< -o $@ $(LDFLAGS)