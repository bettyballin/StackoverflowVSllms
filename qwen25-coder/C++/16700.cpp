#ifdef FROGGERDLL_EXPORTS\n   #define FROGGER_DLLSPEC Q_DECL_EXPORT\n   #else\n   #define FROGGER_DLLSPEC Q_DECL_IMPORT\n   #endif