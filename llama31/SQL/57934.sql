SELECT FormID\nFROM Form\nWHERE CONTAINS(GetAnswerCommentText(FormID), 'search_term');