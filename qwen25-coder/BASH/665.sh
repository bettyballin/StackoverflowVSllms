java -Dcom.sun.management.jmxremote \\n     -Dcom.sun.management.jmxremote.port=9010 \\n     -Dcom.sun.management.jmxremote.local.only=false \\n     -Dcom.sun.management.jmxremote.authenticate=true \\n     -Dcom.sun.management.jmxremote.ssl=false \\n     -Dcom.sun.management.jmxremote.password.file=/path/to/jmxremote.password \\n     -Dcom.sun.management.jmxremote.access.file=/path/to/jmxremote.access \\n     YourApplicatio