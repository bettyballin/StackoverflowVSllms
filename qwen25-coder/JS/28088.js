$(document).on "ajax:success", "[data-remote=true]", (event, data) ->\n     $("#Week_div").html(data.next_week)\n\n     for i in [0..23]\n       for j in [0..6]\n         $("#calendar_div_#{i}_#{j}").html('<td class="available">Available</td>')