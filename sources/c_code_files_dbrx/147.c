#include <stdio.h>
#include <CUnit/Basic.h>
#include <apr_version.h> /* APR Library Module */

/* Define the function to be tested*/
int sum(int a, int b) {
    return a + b;
}

/* Test for sum functionality */
void test_sum(void) {
    CU_ASSERT_EQUAL(sum(2, 3), 5); // Corrected to CU_ASSERT_EQUAL
}

int main() {
    // Initialize CUnit and define the tests
    if (CUE_SUCCESS != CU_initialize_registry())
        return CU_get_error();

    CU_pSuite suite = CU_add_suite("sum_tests", 0, 0);
    if (NULL == suite) {
        CU_cleanup_registry();
        return CU_get_error();
    }

    if ((NULL == CU_add_test(suite, "Test for sum function.", test_sum))) {
        CU_cleanup_registry();
        return CU_get_error();
    }

    // Run the tests and clean up CUnit
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

    return 0;
}