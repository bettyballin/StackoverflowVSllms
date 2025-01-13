#include <stdio.h>\n#include <stdlib.h>\n#include <time.h>\n\nvoid initDeck(int deck[]);\nvoid showDeck(int deck[]);\nvoid shuffleDeck(int deck[]);\nint getBet();\n\nint main() {\n    int deck[52];\n    int playerBet;\n    char z;\n    initDeck(deck);\n    shuffleDeck(deck);\n    showDeck(deck);\n    playerBet = getBet();\n    printf("%d\n", playerBet);\n    z = 1;\n    getchar();\n\n    return 0;\n}\n\nvoid initDeck(int deck[]) {\n    for (int i = 0; i < 52; i++) {\n        deck[i] = i + 1;\n    }\n}\n\nvoid showDeck(int deck[]) {\n    for (int k = 0; k < 52; k++) {\n        printf("%d\n", deck[k]);\n    }\n}\n\nvoid shuffleDeck(int deck[]) {\n    int random, temp;\n    srand(time(0));\n    for (int k = 51; k > 0; k--) {\n        random = rand() % (k + 1);\n        temp = deck[k];\n        deck[k] = deck[random];\n        deck[random] = temp;\n    }\n}\n\nint getBet() {\n    int bet;\n    printf("Enter your bet: ");\n    scanf("%d", &bet);\n    return bet;\n}