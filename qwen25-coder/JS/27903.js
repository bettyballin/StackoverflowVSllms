function autoSlide(ms) {\n    if(sC < 4) {\n        sC++;\n        sA = -(sC - 1) * pH;\n    } else {\n        sC = 1;\n        sA = 0;\n    }\n    slide(ms);\n    if(toSlide === 1) { // Use '===' for strict equality\n        setTimeout ( "autoSlide(sT)", 3000 );\n    }\n}