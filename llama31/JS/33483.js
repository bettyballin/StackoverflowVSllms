var myrange = doc.body.createTextRange();\nmyrange.moveToElementText(newel);\nmyrange.collapse(true); // collapse to the start of the range\nmysel.addRange(myrange);