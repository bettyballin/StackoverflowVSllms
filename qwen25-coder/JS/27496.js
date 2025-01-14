const animate = (duration) => (callback) => {\n     setTimeout(callback, duration);\n   };\n\n   const fadeOut = animate(500);\n\n   fadeOut(() => console.log('Element faded out'));