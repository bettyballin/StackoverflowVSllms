int main()\n{\n    int i;\n    clock_t time1, time2;\n    double diff;\n\n    /* Actual tests start here. */\n    TESTWITH(atan2(0, -1))\n    TESTWITH(acos(-1))\n    TESTWITH(2 * asin(1))\n    TESTWITH(4 * atan2(1, 1))\n    TESTWITH(4 * atan(1))\n\n#if defined(__GNUC__) && (defined(__i386__) || defined(__amd64__))\n    extern double fldpi();\n    TESTWITH(fldpi())\n#endif\n\n    return 0;\n}