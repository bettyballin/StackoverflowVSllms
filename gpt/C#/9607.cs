abstract class A { }\n\nstatic class S\n{\n    public static void DoFirst(A argument) { }\n    public static void DoSecond(ICollection<A> argument) { }\n}\n\nstatic class P<T>\n    where T : A, new()\n{\n    static void Do()\n    {\n        S.DoFirst(new T()); // this call is OK\n\n        // Convert List<T> to ICollection<A>\n        List<T> listT = new List<T>();\n        ICollection<A> collectionA = listT.Cast<A>().ToList();\n\n        S.DoSecond(collectionA); // This should now compile and work correctly\n    }\n}