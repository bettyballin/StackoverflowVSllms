$(document).ready(function() {\n    function setText(){\n        var kf = this.title.split('|');\n        if (kf.length < 0) return;\n        if($('#' + this.name + '_text').hasClass('hint')){\n            $('#' + this.name + '_text').val(kf[0]).addClass('hint');\n        }\n        $('#' + this.name + '_text').attr('title', kf[0]);\n    }\n\n    $("input[type='text']").inputdynvalue();\n    $("input[type='radio']").click(setText);\n});