var s = new java.net.Socket("www.google.com", 80);\nvar sender = new java.io.PrintStream(s.getOutputStream());\nvar receiver = s.getInputStream();\nsender.print("GET / HTTP/1.0\r\n\r\n");\nsender.flush();\ns.shutdownOutput();\n\nvar response = '';\nvar i;\nwhile ((i = receiver.read()) != -1) {\n    response += String.fromCharCode(i);\n}\n\n// At this point, the socket should be closed by the server\nalert(response);\n\n// The socket resources can now be safely closed\ntry { sender.close(); } catch (e) {}\ntry { receiver.close(); } catch (e) {}\ntry { s.close(); } catch (e) {}