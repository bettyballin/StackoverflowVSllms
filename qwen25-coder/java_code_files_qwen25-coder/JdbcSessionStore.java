// File: org/apache/catalina/Session.java
package org.apache.catalina;

public interface Session {
    String getId();
    byte[] getEncodedData();
}