#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <windows.h>

void calcMain(int upperBound, int** known, int* knownSize);

int main()
{
    while(1)
    {
        int* results;
        int resultsSize = 0;
        int upperBound;
        printf("Pick an upper bound: ");
        scanf("%d", &upperBound);
        long start, end;
        start = GetTickCount();
        calcMain(upperBound, &results, &resultsSize);
        end = GetTickCount();
        for (int i = 0; i < resultsSize; ++i) {
            printf("%d, ", results[i]);
        }
        printf("\n");
        double seconds = (double)(end-start) / 1000.0;
        printf("%f seconds.\n\n", seconds);
        free(results);
    }
    return 0;
}

void calcMain(int upperBound, int** known, int* knownSize)
{
    int* history;
    int historySize;
    int* tempResults = malloc((upperBound + 1) * sizeof(int));
    int tempResultsSize = 0;
    for(int i = 0; i <= upperBound; i++)
    {
        int current = i;
        historySize = 0;
        history = malloc((upperBound + 1) * sizeof(int));
        while(1)
        {
                int temp = current;
                int sum = 0;
                while (temp > 0) {
                    sum += (temp % 10) * (temp % 10);
                    temp /= 10;
                }
                current = sum;
                int found = 0;
                for (int j = 0; j < historySize; j++) {
                    if (history[j] == current) {
                        found = 1;
                        break;
                    }
                }
                if(found)
                {
                        if(current == 1)
                        {
                                tempResults[tempResultsSize++] = i;
                        }
                        break;
                }
                history[historySize++] = current;
        }
        free(history);
    }
    *known = tempResults;
    *knownSize = tempResultsSize;
}