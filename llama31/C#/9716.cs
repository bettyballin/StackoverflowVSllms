public IClass2[] getList()\n{\n    // ...\n    IClass2[] a = new IClass2[this.MyList.Count];\n    // ...\n    return (IClass2[])Marshal.CreateSafeArray(typeof(IClass2), a);\n}