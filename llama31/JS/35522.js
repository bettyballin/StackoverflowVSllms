const canvas = document.createElement('canvas');\nconst ctx = canvas.getContext('2d');\n// ...\nconst fingerprint = {\n  screenResolution: `${screen.width}x${screen.height}`,\n  colorDepth: screen.colorDepth,\n  plugins: navigator.plugins.map((p) => p.name),\n  // ...\n};