jQuery.ajaxSetup({\n  beforeSend: function(xhr) {\n    xhr.setRequestHeader("Accept", "text/javascript");\n  }\n});\n\njQuery.fn.submitWithAjax = function() {\n  this.submit(function() {\n    $.post(this.action, $(this).serialize(), null, "script");\n    return false;\n  });\n  return this;\n};\n\n$('.error').hide();\n\n$("#business_submit").click(function() {\n  // validate and process form here\n\n  $('.error').hide();\n  var name = $("input#business_name").val();\n  if (name == "" || name == "Required Field") {\n    $('#namelabel').show();\n    $("#business_name").focus();\n    return false;\n  }\n\n  // Other validation checks...\n\n  var form = $("#new_business");\n  $.ajax({\n    type: "POST",\n    url: form.attr('action'),\n    data: form.serialize(),\n    dataType: "script"\n  });\n  return false;\n});