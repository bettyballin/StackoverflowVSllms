var myrange = doc.body.createTextRange();\nmyrange.moveToElement(newel);\nmyrange.collapse(true); // collapse to the start of the range\nmysel.addRange(myrange);