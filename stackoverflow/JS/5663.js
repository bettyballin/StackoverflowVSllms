$(".entries a").hover(\n  function () {\n   $(this).find("em").slideDown(500);\n  }, \n  function () {\n  $(this).find("em").slideUp(500);\n  }\n);