#include <CUnit/Basic.h>\n\nint add(int a, int b) {\n    return a + b;\n}\n\nvoid test_add(void) {\n    CU_ASSERT_EQUAL(add(2, 3), 5);\n}\n\nint main(void) {\n    CU_initialize_registry();\n    CU_add_suite("Test Suite", NULL, NULL);\n    CU_add_test("Test Suite", "test_add", test_add);\n    CU_run_tests();\n    CU_cleanup_registry();\n    return 0;\n}