#include <stdio.h>

// Define a struct with a member and a pointer to the same struct type
typedef struct Member {
    int member;
    struct Member* p_member;
} Member;

int main() {
    // Create instances of the struct
    Member m3 = {3, NULL};
    Member m2 = {2, &m3};
    Member m1 = {1, &m2};

    // Access the nested member
    Member* p_member = &m1;
    printf("%d\n", p_member->p_member->p_member->member);

    return 0;
}