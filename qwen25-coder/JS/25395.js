var LOCATION = 'http://www.google.com/ig/api?weather=';\n\n$( document ).ready( function() {\n    for( var cityIdx = 0; cityIdx < cities.length; cityIdx++ ) {\n        (function(currentCityIdx) {\n            $.ajax({\n                type: 'GET',\n                url: LOCATION + cities[ currentCityIdx ],\n                dataType: 'xml',\n                success: function( xml ) {\n                    if( $( xml ).find( 'problem_cause' ).length > 0 ) {\n                        // Do what you want with the data returned\n                        var weather = $( xml ).find( 'temp_c' ).attr( 'data' );\n                        // Display city and weather on your page\n                        $('#weatherDisplay').append('<div>' + cities[currentCityIdx] + ': ' + weather + '°C</div>');\n                    }\n                },\n                error: function() {\n                    console.error('Failed to retrieve weather data for ' + cities[currentCityIdx]);\n                }\n            });\n        })(cityIdx);\n    }\n});