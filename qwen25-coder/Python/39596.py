from py4j.java_gateway import JavaGateway\n\n# Initialize the Java Gateway\ngateway = JavaGateway()\n\n# Access a method in Java (example)\njava_util_random = gateway.jvm.java.util.Random()\nrandom_integer = java_util_random.nextInt(100)\n\nprint(random_integer)