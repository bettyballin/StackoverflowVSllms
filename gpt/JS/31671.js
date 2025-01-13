$(document).ready(function() {\n    const regions = {\n        USA: ["California", "Texas", "New York"],\n        Canada: ["Ontario", "Quebec", "British Columbia"]\n    };\n\n    const cities = {\n        "California": ["Los Angeles", "San Francisco", "San Diego"],\n        "Texas": ["Houston", "Dallas", "Austin"],\n        "New York": ["New York City", "Buffalo", "Rochester"],\n        "Ontario": ["Toronto", "Ottawa", "Hamilton"],\n        "Quebec": ["Montreal", "Quebec City", "Laval"],\n        "British Columbia": ["Vancouver", "Victoria", "Surrey"]\n    };\n\n    $('#country').change(function() {\n        const country = $(this).val();\n        const regionSelect = $('#region');\n        regionSelect.empty();\n        regionSelect.append('<option value="">Select Region</option>');\n        if (country) {\n            regions[country].forEach(function(region) {\n                regionSelect.append('<option value="' + region + '">' + region + '</option>');\n            });\n        }\n        $('#city').val('');\n    });\n\n    $('#region').change(function() {\n        $('#city').val('');\n    });\n\n    $('#city').autocomplete({\n        source: function(request, response) {\n            const region = $('#region').val();\n            if (region && cities[region]) {\n                const filteredCities = cities[region].filter(function(city) {\n                    return city.toLowerCase().startsWith(request.term.toLowerCase());\n                });\n                response(filteredCities);\n            } else {\n                response([]);\n            }\n        },\n        minLength: 1\n    });\n});