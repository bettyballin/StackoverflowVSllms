#include <stdlib.h>
#include <stdio.h>

static int *a;
static int n;

void print_bracelet(int n, int a[]) {
    int i;

    printf("[");
    for (i = 0; i < n; i++) {
        printf(" %c", 'a' + a[i]);
    }
    printf(" ]\n");
}

int check_rev(int t, int i) {
    int j;

    for (j = i + 1; j <= (t + 1) / 2; j++) {
        if (a[j] < a[t - j + 1]) {
            return 0;
        }
        if (a[j] > a[t - j + 1]) {
            return -1;
        }
    }

    return 1;
}

void gen_bracelets(int n_a, int n_b, int t, int p, int r, int u, int v, int rs) {
    if (2 * (t - 1) > (n + r)) {
        if (a[t - 1] > a[n - t + 2 + r]) {
            rs = 0;
        } else if (a[t - 1] < a[n - t + 2 + r]) {
            rs = 1;
        }
    }
    if (t > n) {
        if (!rs && (n % p) == 0) {
            print_bracelet(n, a + 1);
        }
    } else {
        int n_a2 = n_a;
        int n_b2 = n_b;

        a[t] = a[t - p];

        if (a[t] == 0) {
            n_a2--;
        } else {
            n_b2--;
        }

        if (a[t] == a[1]) {
            v++;
        } else {
            v = 0;
        }

        if ((u == (t - 1)) && (a[t - 1] == a[1])) {
            u++;
        }

        if ((n_a2 >= 0) && (n_b2 >= 0) && !((t == n) && (u != n) && (a[n] == a[1]))) {
            if (u == v) {
                int rev = check_rev(t, u);

                if (rev == 0) {
                    gen_bracelets(n_a2, n_b2, t + 1, p, r, u, v, rs);
                }

                if (rev == 1) {
                    gen_bracelets(n_a2, n_b2, t + 1, p, t, u, v, 0);
                }
            } else {
                gen_bracelets(n_a2, n_b2, t + 1, p, r, u, v, rs);
            }
        }

        if (u == t) {
            u--;
        }

        if (a[t - p] == 0 && n_b > 0) {
            a[t] = 1;

            if (t == 1) {
                gen_bracelets(n_a, n_b - 1, t + 1, t, 1, 1, 1, rs);
            } else {
                gen_bracelets(n_a, n_b - 1, t + 1, t, r, u, 0, rs);
            }
        }
    }
}

int main(int argc, char* argv[]) {
    int n_a, n_b;

    if (argc < 3) {
        fprintf(stderr, "Usage: %s <a> <b>\n", argv[0]);
        return -2;
    }

    n_a = atoi(argv[1]);
    n_b = atoi(argv[2]);

    if (n_a < 0 || n_b < 0) {
        fprintf(stderr, "a and b must be nonnegative\n");
        return -3;
    }

    n = n_a + n_b;
    a = malloc((n + 1) * sizeof(int));

    if (!a) {
        fprintf(stderr, "could not allocate array\n");
        return -1;
    }

    a[0] = 0;

    gen_bracelets(n_a, n_b, 1, 1, 0, 0, 0, 0);

    free(a);
    return 0;
}