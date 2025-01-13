require 'ncurses'\n\ndef main\n  Ncurses.initscr\n  Ncurses.cbreak\n  Ncurses.noecho\n  Ncurses.curs_set(0)\n\n  chat_win_height = Ncurses.LINES - 3\n  input_win_height = 3\n\n  chat_win = Ncurses.newwin(chat_win_height, Ncurses.COLS, 0, 0)\n  input_win = Ncurses.newwin(input_win_height, Ncurses.COLS, chat_win_height, 0)\n\n  chat_win.scrollok(true)\n  input_win.scrollok(false)\n\n  chat_log = []\n\n  loop do\n    input_win.clear\n    input_win.refresh\n    input_win.box(0, 0)\n    input_win.mvprintw(1, 1, '> ')\n    input_win.refresh\n\n    input = get_input(input_win)\n\n    if input.strip == 'exit'\n      break\n    end\n\n    chat_log << input.strip\n\n    chat_win.clear\n    chat_win.box(0, 0)\n    chat_log.last(chat_win_height - 2).each_with_index do |msg, index|\n      chat_win.mvprintw(index + 1, 1, msg)\n    end\n    chat_win.refresh\n  end\n\n  Ncurses.endwin\nend\n\ndef get_input(win)\n  buffer = ''\n  while (ch = win.getch) != 10  # 10 is the ASCII code for Enter\n    if ch == 127 || ch == Ncurses::KEY_BACKSPACE\n      buffer.chop!\n    else\n      buffer += ch.chr\n    end\n    win.mvprintw(1, 3, buffer)\n    win.refresh\n  end\n  buffer\nend\n\nmai