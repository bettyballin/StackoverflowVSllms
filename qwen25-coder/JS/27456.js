<script>\n    if ("geolocation" in navigator) {\n        navigator.geolocation.getCurrentPosition(function(position) {\n            var latitude = position.coords.latitude;\n            var longitude = position.coords.longitude;\n\n            // Append your script or handle the coordinates as needed\n            var script = document.createElement('script');\n            script.type = 'text/javascript';\n            script.src = 'http://www.mysite.com/widget.php?mid=12&lat=' + encodeURIComponent(latitude) + '&lon=' + encodeURIComponent(longitude);\n            \n            document.head.appendChild(script);\n        }, function() {\n            console.error("Location retrieval failed");\n        });\n    } else {\n        console.error("Geolocation is not supported by this browser.");\n    }\n</script>