#include <iostream>\n#include <ostream>\nusing namespace std;\n\ntemplate <int N>\nstruct P\n{\n    enum { val = P<N/2>::val * 2 };\n};\n\ntemplate <>\nstruct P<0>\n{\n    enum { val = 1 };\n};\n\ntemplate <class T>\nstruct PadSize\n{\n    enum { val = P<sizeof (T) - 1>::val - sizeof (T) }; \n};\n\ntemplate <class T, int N>\nstruct PossiblyPadded\n{\n    T       payload;\n    char    pad[N]; \n};\n\ntemplate <class T>\nstruct PossiblyPadded<T, 0>\n{\n    T       payload;\n};\n\ntemplate <class T>\nstruct Holder : public PossiblyPadded<T, PadSize<T>::val>\n{\n};\n\n\nint main()\n{\n    typedef char Arr[6];\n\n    Holder<Arr> holder;\n    cout << sizeof holder.payload << endl;\n\n    // Next line fails to compile if sizeof (Arr) is a power of 2\n    // but holder.payload always exists\n    cout << sizeof holder.pad << endl;\n}