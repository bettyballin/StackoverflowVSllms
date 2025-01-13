for (i = 1; i<length; i++) {\n    value = particles[i]; // store particles[i] rather than it's x coordinate\n    j = i - 1;\n    while (j >= 0 && particles[j].position.x > value.position.x) { // changed\n        particles[j+1] = particles[j];\n        j = j - 1;\n    }\n    particles[j+1] = value; // copy from temporary\n}