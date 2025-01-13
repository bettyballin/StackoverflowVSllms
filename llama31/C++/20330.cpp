// Example of a simple HL2 SDK mod that prints a message to the console\n#include "cbase.h"\n\nclass CMyMod : public CBaseEntity\n{\npublic:\n    DECLARE_CLASS(CMyMod, CBaseEntity);\n\n    void Spawn()\n    {\n        Msg("Hello, World!\n");\n    }\n};\n\nREGISTER_ENTITY(CMyMod, "mymod");