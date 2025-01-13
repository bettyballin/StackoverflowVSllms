document.addEventListener('DOMContentLoaded', function() {\n    var calendarEl = document.getElementById('calendar');\n    var calendar = new FullCalendar.Calendar(calendarEl, {\n        initialView: 'timeGridWeek',\n        events: '/appointments/get' // URL to fetch appointments\n    });\n    calendar.render();\n});