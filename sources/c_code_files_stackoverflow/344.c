#include <stdio.h>

#define N 10 // Define the value of N

int main() {
    int T[N] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}; // Initialize array T
    int i, j, next, prev;

    for(int i=0; i<N; i++) {
        if(T[i]>=N) continue;
        j=T[i];
        prev=i;
        while(j < N) {
            next=T[j];
            T[j]=prev+N;
            prev=j;
            j=next;
        }
    }

    for(int i=0; i<N; i++)
        T[i]-=N;

    // Print the modified array
    for (int i = 0; i < N; i++) {
        printf("%d ", T[i]);
    }
    printf("\n");

    return 0;
}