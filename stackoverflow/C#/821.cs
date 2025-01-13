[WebMethod()]\n   [XmlInclude(typeof(Car)), XmlInclude(typeof(Bike))]\n   public Vehicle Vehicle(string licenseNumber) {\n      if (licenseNumber == "0") {\n         Vehicle v = new Car();\n         v.licenseNumber = licenseNumber;\n         return v;\n      }\n      else if (licenseNumber == "1") {\n          Vehicle v = new Bike();\n          v.licenseNumber = licenseNumber;\n          return v;\n      }\n      else {\n         return null;\n      }\n   }