function drawChart() {\n  var data = google.visualization.arrayToDataTable([\n    ['Label', 'Value'],\n    ['Long label 1', 10],\n    ['Long label 2', 20],\n    ['Long label 3', 30],\n    // ...\n  ]);\n\n  var options = {\n    hAxis: {\n      slantedText: true,\n      slantedTextAngle: 90,\n      showTextEvery: 1\n    }\n  };\n\n  var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));\n  chart.draw(data, options);\n}