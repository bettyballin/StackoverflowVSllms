void assignObject(ClassA** pa, ClassB** pb) {\n  *pa = new ClassA;\n  *pb = new ClassB;\n}\n\n// Usage:\nClassA* pa = NULL;\nClassA* pb = NULL;\n\nassignObject(&pa, &pb);