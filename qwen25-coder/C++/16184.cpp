amespace nsA {\n    namespace subA {\n        void someOtherFunction() {\n            nsB::theFunctionInNsB(); // Correct way to call the function from nsB\n        }\n    }\n}