#include <stdio.h>
#include <stdlib.h>

// Define the userlist structure
typedef struct userlist {
    char *username;
    struct userlist *next;
} userlist;

// External variables used in the original function
userlist *userlist_head = NULL;
int usercount_ = 0;

// Function to add a new user to the list (for demonstration)
void add_user(char *username) {
    userlist *new_user = malloc(sizeof(userlist));
    new_user->username = username;
    new_user->next = NULL;

    if (userlist_head == NULL) {
        userlist_head = new_user;
    } else {
        userlist *cur = userlist_head;
        while (cur->next != NULL) {
            cur = cur->next;
        }
        cur->next = new_user;
    }
    usercount_++;
}

// The original function with necessary modifications for gcc
void update_userlist(char **ulist) {
    int i = 0;
    userlist *cur_user = userlist_head; // pointer to the first item in the linked list

    for (; i < usercount_; ++i) {
        ulist[i] = cur_user->username;
        cur_user = cur_user->next;
    }
}

int main() {
    // Example usage
    add_user("Alice");
    add_user("Bob");
    add_user("Charlie");

    char *usernames[usercount_];
    update_userlist(usernames);

    for (int i = 0; i < usercount_; i++) {
        printf("%s\n", usernames[i]);
    }

    return 0;
}