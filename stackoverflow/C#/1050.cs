//expect that ChildMethod1() will be called once. (it's protected)\n  testBaseMock.Protected().Expect("ChildMethod1")\n    .AtMostOnce()\n    .Verifiable();\n\n  ...\n\n  //make sure the method was called\n  testBase.Verify();