var opts = {\n  lines: 12, // The number of lines to draw\n  angle: 0.9, // The length of each line\n  lineWidth: 0.44, // The line thickness\n  pointer: {\n    length: 0.6, // The radius of the inner circle\n    strokeWidth: 0.035, // The rotation offset\n    color: '#000000' // Fill color\n  },\n  limitMax: false,     // If true, the max value of the gauge will be limited to the actual maximum value instead of a pre-specified amount.\n  colorStart: '#6FADCF',   // Colors\n  colorStop: '#8FC0DA',    // just as you would write in css, can also be a function that depending on your data returns an rgb value string,\n  radiusScale: 1.0 / 3,        // Relative radius of the plugin container draw area to the original canvas size\n  pointerRadiusScale: 1,\n  lineWidth: 0.26, // The thickness\n  shadowEnable: true, // Whether to render a shadow\n  shadowUmbrellaLength: 0, // Will add a transparent overlay on top of the gauge.\n};\nvar target = document.getElementById('foo'); // your canvas element\nvar gauge = new Gauge(target).setOptions(opts); // create sexy gauge!\ngauge.maxValue = 3000; // set max gauge value\ngauge.setMinValue(0);  // Prefer setter over gauge.minValue = 0\ngauge.animationSpeed = 32; // set animation speed (32 is default value)\ngauge.set(1250); // set actual value