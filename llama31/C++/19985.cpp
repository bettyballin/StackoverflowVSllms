struct MyObject {\n  void func();\n};\n\nvoid MyObject::func() {\n  if (!this) {\n    // this is never reached\n    throw std::logic_error("this is never null");\n  }\n}\n\nint main() {\n  MyObject* obj = nullptr;\n\n  // this is undefined behavior\n  obj->func();\n}