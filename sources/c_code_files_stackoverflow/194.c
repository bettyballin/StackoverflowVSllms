#ifdef SOME_CONDITION
#define MYIMPORTEXPORT __declspec(dllexport)
#else
#define MYIMPORTEXPORT __declspec(dllimport)
#endif

MYIMPORTEXPORT int some_function(void) {
    return 42;
}

int main() {
    return some_function();
}