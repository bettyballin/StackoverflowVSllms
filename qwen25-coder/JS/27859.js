$("p>img").each(function () {\n    if (this == this.parentNode.firstChild) {\n        $(this).parent().before(this);\n    } else {\n        $(this).parent().after(this);\n    }\n});