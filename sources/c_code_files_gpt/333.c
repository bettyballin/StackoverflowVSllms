#include <stdio.h>
#include <string.h>

int lookup(char *word, char *array[])
{
    register int i;

    for (i = 0; array[i] != NULL; i++)
    {
        if (strcmp(word, array[i]) == 0)
            return i;
    }

    return -1;
}

int main()
{
    char *words[] = {"apple", "banana", "cherry", NULL};
    char *target = "banana";
    int result = lookup(target, words);

    if (result != -1)
    {
        printf("Found '%s' at index %d.\n", target, result);
    }
    else
    {
        printf("Did not find '%s'.\n", target);
    }

    return 0;
}