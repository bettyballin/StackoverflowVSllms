function One() {\n  $('div#animateTest1').animate({ left: '+=200' }, 2000);\n}\n\nfunction Two() {\n  $('div#animateTest2').animate({ width: '+=200' }, 2000);\n}\n\n// Queue the functions\n$(document).queue('myQueue', One);\n$(document).queue('myQueue', Two);\n$(document).dequeue('myQueue');