public class MyClass {\n  private void method1() {\n    Session["anObject"] = new SomeObject();\n  }\n  private void method2() {\n    SomeObject anObject = (SomeObject)Session["anObject"];\n    // do something with anObject\n  }\n}