function show(jobNo) {\n    // Open a new window with URL that includes the job number as query parameter\n    var url = 'details.php?job_no=' + encodeURIComponent(jobNo);\n    window.open(url, '_blank', 'width=600,height=400');\n}