#include <stdlib.h>
#include <string.h>

// Assuming userlist is a struct with username and next as members
typedef struct userlist {
    char *username;
    struct userlist *next;
} userlist;

// Assuming userlist_head and usercount_ are global variables
userlist *userlist_head;
int usercount_;

void update_userlist(char ***ulist) {
    int i = 0;
    userlist *cur_user = userlist_head; // pointer to first item in linked list

    for (i = 0, cur_user = userlist_head; i < usercount_ && cur_user != NULL; ++i) {
        (*ulist)[i] = strdup(cur_user->username); // make a copy of the string using strdup()
        cur_user = cur_user->next;
    }
}