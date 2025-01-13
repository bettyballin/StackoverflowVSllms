/*\n** find rational approximation to given real number\n** David Eppstein / UC Irvine / 8 Aug 1993\n**\n** With corrections from Arno Formella, May 2008\n**\n** usage: a.out r d\n**   r is real number to approx\n**   d is the maximum denominator allowed\n**\n** based on the theory of continued fractions\n** if x = a1 + 1/(a2 + 1/(a3 + 1/(a4 + ...)))\n** then best approximation is found by truncating this series\n** (with some adjustments in the last term).\n**\n** Note the fraction can be recovered as the first column of the matrix\n**  ( a1 1 ) ( a2 1 ) ( a3 1 ) ...\n**  ( 1  0 ) ( 1  0 ) ( 1  0 )\n** Instead of keeping the sequence of continued fraction terms,\n** we just keep the last partial product of these matrices.\n*/\n\n#include <stdio.h>\n\nmain(ac, av)\nint ac;\nchar ** av;\n{\n    double atof();\n    int atoi();\n    void exit();\n\n    long m[2][2];\n    double x, startx;\n    long maxden;\n    long ai;\n\n    /* read command line arguments */\n    if (ac != 3) {\n        fprintf(stderr, "usage: %s r d\n",av[0]);  // AF: argument missing\n        exit(1);\n    }\n    startx = x = atof(av[1]);\n    maxden = atoi(av[2]);\n\n    /* initialize matrix */\n    m[0][0] = m[1][1] = 1;\n    m[0][1] = m[1][0] = 0;\n\n    /* loop finding terms until denom gets too big */\n    while (m[1][0] *  ( ai = (long)x ) + m[1][1] <= maxden) {\n        long t;\n        t = m[0][0] * ai + m[0][1];\n        m[0][1] = m[0][0];\n        m[0][0] = t;\n        t = m[1][0] * ai + m[1][1];\n        m[1][1] = m[1][0];\n        m[1][0] = t;\n        if(x==(double)ai) break;     // AF: division by zero\n        x = 1/(x - (double) ai);\n        if(x>(double)0x7FFFFFFF) break;  // AF: representation failure\n    } \n\n    /* now remaining x is between 0 and 1/ai */\n    /* approx as either 0 or 1/m where m is max that will fit in maxden */\n    /* first try zero */\n    printf("%ld/%ld, error = %e\n", m[0][0], m[1][0],\n           startx - ((double) m[0][0] / (double) m[1][0]));\n\n    /* now try other possibility */\n    ai = (maxden - m[1][1]) / m[1][0];\n    m[0][0] = m[0][0] * ai + m[0][1];\n    m[1][0] = m[1][0] * ai + m[1][1];\n    printf("%ld/%ld, error = %e\n", m[0][0], m[1][0],\n           startx - ((double) m[0][0] / (double) m[1][0]));\n}