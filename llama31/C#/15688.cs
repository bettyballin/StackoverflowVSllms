public class WebServiceWarmUp\n{\n    public void WarmUp()\n    {\n        // Call infrequently used web service methods\n        MyWebServiceMethod1();\n        MyWebServiceMethod2();\n        // ...\n    }\n}