mapObject.prototype.SetLocation = (response) => {\n    this.geoStatusCode = response.Status.code;\n    alert("entered SetLocation with status code " + this.geoStatusCode);\n    if (this.geoStatusCode == 200) {\n        this.lat = response.Placemark[0].Point.coordinates[1];\n        this.lng = response.Placemark[0].Point.coordinates[0];\n        alert("calling create()");\n        this.Create(); // "no such function"\n    } else {\n        this.geofailed++;\n    }\n};\n\n// When you set the callback, use an arrow function to maintain context\nGetLocations((response) => this.SetLocation(response));