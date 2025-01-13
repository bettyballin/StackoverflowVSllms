// predictor.c\nvoid predictor_encode(const unsigned char *in, unsigned char *out, int len) {\n    int i;\n    unsigned char delta = 0;\n    for (i = 0; i < len; i++) {\n        delta = in[i] - delta;\n        out[i] = delta;\n        delta = in[i];\n    }\n}\n\nvoid predictor_decode(const unsigned char *in, unsigned char *out, int len) {\n    int i;\n    unsigned char delta = 0;\n    for (i = 0; i < len; i++) {\n        out[i] = in[i] + delta;\n        delta = out[i];\n    }\n}