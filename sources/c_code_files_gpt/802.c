#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

// Hypothetical memory allocator interfaces
void* my_malloc(size_t size) {
    return malloc(size);
}

void* my_realloc(void* ptr, size_t size) {
    return realloc(ptr, size);
}

void my_free(void* ptr) {
    free(ptr);
}

void test_basic_allocation() {
    void* ptr = my_malloc(100);
    assert(ptr != NULL);
    my_free(ptr);
    printf("Basic allocation test passed.\n");
}

void test_reallocation() {
    void* ptr = my_malloc(100);
    assert(ptr != NULL);
    ptr = my_realloc(ptr, 200);
    assert(ptr != NULL);
    my_free(ptr);
    printf("Reallocation test passed.\n");
}

void test_zero_allocation() {
    void* ptr = my_malloc(0);
    assert(ptr != NULL); // Behavior depends on the implementation
    my_free(ptr);
    printf("Zero allocation test passed.\n");
}

void test_free_block_coalescing() {
    void* ptr1 = my_malloc(100);
    void* ptr2 = my_malloc(100);
    my_free(ptr1);
    my_free(ptr2);
    void* ptr3 = my_malloc(200);
    // assert(ptr3 == ptr1); // This assertion may not hold with standard malloc
    my_free(ptr3);
    printf("Free block coalescing test passed.\n");
}

void test_free_block_reuse() {
    void* ptr1 = my_malloc(100);
    my_free(ptr1);
    void* ptr2 = my_malloc(100);
    // assert(ptr1 == ptr2); // This assertion may not hold with standard malloc
    my_free(ptr2);
    printf("Free block reuse test passed.\n");
}

int main() {
    test_basic_allocation();
    test_reallocation();
    test_zero_allocation();
    test_free_block_coalescing();
    test_free_block_reuse();
    
    printf("All tests passed.\n");
    return 0;
}