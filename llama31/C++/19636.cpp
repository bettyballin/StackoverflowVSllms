#include <Ethernet.h>\n\n// Define the Easy Button pin\nconst int buttonPin = 2;\n\n// Define the Ethernet shield\nbyte mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };\nIPAddress ip(192, 168, 1, 100);\nEthernetUDP Udp;\n\nvoid setup() {\n  pinMode(buttonPin, INPUT);\n  Ethernet.begin(mac, ip);\n  Udp.begin(1234); // Choose a UDP port\n}\n\nvoid loop() {\n  if (digitalRead(buttonPin) == HIGH) {\n    // Send a UDP packet\n    char packet[] = "Easy Button pressed!";\n    Udp.beginPacket(Udp.remoteIP(), 1234);\n    Udp.write(packet, strlen(packet));\n    Udp.endPacket();\n  }\n  delay(50);\n}