(\n    (R.reviewStart BETWEEN M.meetingStart AND M.meetingEnd) OR\n    (R.reviewEnd BETWEEN M.meetingStart AND M.meetingEnd) OR\n    (M.meetingStart BETWEEN R.reviewStart AND R.reviewEnd) OR\n    (M.meetingEnd BETWEEN R.reviewStart AND R.reviewEnd)\n)