function calculateTravelTime() {\n    const origin = "New York, NY";\n    const destination = "Los Angeles, CA";\n    const service = new google.maps.DirectionsService();\n\n    service.route({\n        origin: origin,\n        destination: destination,\n        travelMode: 'DRIVING'\n    }, function(response, status) {\n        if (status === 'OK') {\n            // Extract the duration from the response\n            const duration = response.routes[0].legs[0].duration.text;\n            console.log('Estimated travel time: ' + duration);\n            // You can now use this duration value in your site without showing a map\n        } else {\n            window.alert('Directions request failed due to ' + status);\n        }\n    });\n}