class D : C { }\n\nclass B<T> where T : C\n{\n    public B()\n    {\n        A<T> a = new A<T>();\n        a.Add(new C()); // what if T is D?\n    }\n}