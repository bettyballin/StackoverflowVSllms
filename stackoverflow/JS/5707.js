var myFunction = {\n     kick:  kick,\n     push:  push,\n     shove: shove\n};\n\n$("#button_holder > span").each(function () {\n    var doThis = this.id;\n    $(this).click(myFunction[doThis]);\n});