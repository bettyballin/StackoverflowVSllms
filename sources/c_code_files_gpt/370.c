#include <stdio.h>
#include <conio.h>

int choi(char *Tvide[48]) {
    char fum, classe, pos;

    printf("S.V.P choisissez votre Classe   (A:1 ere classe )/(B: 2 eme classe): ");
    classe = getche();
    printf("Est ce que vous etes fumeur   (O:fumeur)/(N:non fumeur):");
    fum = getche();
    printf("S.V.P vous preferez s'assoir pres de la fenetre ou du couloir(C:couloir )/(F:fenetre):");
    pos = getche();

    int Tfum[24] = {3,4,7,8,11,12,15,16,19,20,23,24,27,28,31,32,35,36,39,40,43,44,47,48};
    int Tnfum[24] = {1,2,5,6,9,10,13,14,17,18,21,22,25,26,29,30,33,34,37,38,41,42,45,46};
    int Tfen[24] = {1,4,5,8,9,12,13,16,17,20,21,24,25,28,29,32,33,36,37,40,41,44,45,48};
    int Tcol[24] = {2,3,6,7,10,11,14,15,18,19,22,23,26,27,30,31,34,35,38,39,42,43,46,47};
    int k;

    char Tdispo[48];

    for(k = 0; k < 48; k++) {
        Tdispo[k] = 'o';
    }

    if (classe == 'A') {
        for(k = 8; k < 48; k++) {
            Tdispo[k] = 'n';
        }
    }
    if (classe == 'B') {
        for(k = 0; k < 8; k++) {
            Tdispo[k] = 'n';
        }
    }
    if (fum == 'O') {
        for(k = 0; k < 24; k++) {
            Tdispo[Tnfum[k] - 1] = 'n'; // Subtract 1 because Tnfum is 1-based
        }
    }
    if (fum == 'N') {
        for(k = 0; k < 24; k++) {
            Tdispo[Tfum[k] - 1] = 'n'; // Subtract 1 because Tfum is 1-based
        }
    }
    if (pos == 'C') {
        for(k = 0; k < 24; k++) {
            Tdispo[Tfen[k] - 1] = 'n'; // Subtract 1 because Tfen is 1-based
        }
    }
    if (pos == 'F') {
        for(k = 0; k < 24; k++) {
            Tdispo[Tcol[k] - 1] = 'n'; // Subtract 1 because Tcol is 1-based
        }
    }

    int s;

    printf("Les places disponibles sont:");

    for(s = 0; s < 48; s++) {
        if(Tdispo[s] == 'o') {
            printf("%d~", s + 1); // Add 1 to convert back to 1-based index for display
        }
    }

    int ch;
    printf("S.V.P introduire votre choix :");
    scanf("%d", &ch); // Use &ch to pass the address

    (*Tvide)[ch - 1] = 'n'; // Subtract 1 because Tvide is 0-based and use the correct pointer syntax
    return ch;
}

int main() {
    char Tvide[48];
    choi(&Tvide);
    return 0;
}