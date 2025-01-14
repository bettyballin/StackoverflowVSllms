#if defined(_WIN32) && defined(TEST_EXPORTS)
#define TEST_API __attribute__((dllexport))
#elif defined(_WIN32)
#define TEST_API __attribute__((dllimport))
#else
#define TEST_API
#endif

TEST_API void test_function() {
    // Your code here
}

int main() {
    test_function();
    return 0;
}