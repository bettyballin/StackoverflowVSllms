// In Library project\n   using SomeDllNamespace;\n\n   namespace Library\n   {\n       public static class SomeDllFacade\n       {\n           public static void DoSomething()\n           {\n               SomeDll.SomeMethod();\n           }\n           \n           // Add other necessary methods to expose\n       }\n   }