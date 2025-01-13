(function ($) {\n  $.fn.serializeDisabled = function () {\n    var obj = {};\n\n    $(':disabled[name]', this).each(function () { \n        obj[this.name] = $(this).val(); \n    });\n    return $.param(obj);\n  }\n})(jQuery);