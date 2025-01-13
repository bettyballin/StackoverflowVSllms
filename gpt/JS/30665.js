function buildCal() {\n    var d = new Date();\n    var month = d.getMonth() + 1;\n    var year = d.getFullYear();\n    var monthName = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];\n    var daysInMonth = [31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];\n\n    var objectDay = new Date(year, month - 1, 1);\n    objectDay.od = objectDay.getDay() + 1;\n\n    var todaydate = new Date();\n    var scanfortoday = (year == todaydate.getFullYear() && month == todaydate.getMonth() + 1) ? todaydate.getDate() : 0;\n\n    daysInMonth[1] = (((objectDay.getFullYear() % 100 != 0) && (objectDay.getFullYear() % 4 == 0)) || (objectDay.getFullYear() % 400 == 0)) ? 29 : 28;\n\n    var t = '';\n    t += '<table><tr><th colspan="7">' + monthName[month - 1] + ' - ' + year + '</th></tr>';\n    t += '<tr>';\n    for (s = 0; s < 7; s++) t += '<td>' + "DoLuMaMiJuViSa".substr(s * 2, 2) + '</td>';\n    t += '</tr><tr>';\n\n    for (i = 2; i <= 42; i++) {\n        var x = ((i - objectDay.od >= 0) && (i - objectDay.od < daysInMonth[month - 1])) ? i - objectDay.od + 1 : '&nbsp;';\n        if (x != '&nbsp;') {\n            t += '<td class="date" data-date="' + year + '-' + (month < 10 ? '0' : '') + month + '-' + (x < 10 ? '0' : '') + x + '">' + x + '</td>';\n        } else {\n            t += '<td class="padding">' + x + '</td>';\n        }\n        if ((i) % 7 == 0 && i < 36) t += '</tr><tr>';\n    }\n    t += '</tr></table>';\n\n    document.getElementById('calendar').innerHTML = t;\n\n    // Fetch events and mark them on the calendar\n    fetch('events.php')\n        .then(response => response.json())\n        .then(events => {\n            events.forEach(event => {\n                let eventDate = document.querySelector(`td[data-date="${event.date}"]`);\n                if (eventDate) {\n                    eventDate.classList.add('event');\n                    eventDate.setAttribute('title', event.title);\n                }\n            });\n        })\n        .catch(error => console.error('Error fetching events:', error));\n}\n\n// Call buildCal on page load\ndocument.addEventListener('DOMContentLoaded', buildCal);