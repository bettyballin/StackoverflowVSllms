$(function() {
\n  $("#msg").text('');
\n
\n  $("#checkdates").click(function(event) {
\n    var startdate = Date.parse($("#startdate").val());
\n    if (!startdate) {
\n      $("#msg").append("Start Date is not a valid date<br/>");
\n    }
\n
\n    var enddate = Date.parse($("#enddate").val());
\n    if (!enddate) {
\n      $("#msg").append("End Date is not a valid date<br/>");
\n    }
\n
\n    if (startdate && enddate) {
\n      if (startdate < enddate) {
\n        $("#msg").text("Start date must be greater than end date");
\n      } else {
\n        $("#msg").text("all good!");
\n      }
\n    }
\n    event.preventDefault();
\n    return false;
\n  });
\n});