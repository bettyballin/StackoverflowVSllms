#include <stdio.h>

int main() {
    char m_primaryKey[1024]; // assuming a fixed-size buffer
    int m_primaryKeyLength = 0;
    int idx = 0;
    char primaryCharacter(int index); // assuming a function declaration

    m_primaryKey[m_primaryKeyLength] = primaryCharacter(idx);
    m_primaryKeyLength += 1;
    idx += 1;

    return 0;
}

char primaryCharacter(int index) {
    // implementation of primaryCharacter function
    // this is just a dummy example
    return 'a' + index;
}