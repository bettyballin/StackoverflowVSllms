require 'curses'\n\n# Initialize curses\nCurses.init_screen\n\nbegin\n  # Create two virtual windows: one for logs, another for input\n  log_window = Curses::Window.new(Curses.lines - 2, Curses.cols, 0, 0)\n  input_window = Curses::Window.new(1, Curses.cols, Curses.lines - 2, 0)\n\n  # Enable echo and line buffer only on the input window\n  input_window.keypad(true)\n  input_window.timeout = 100 # Timeout in milliseconds\n  input_window.setscrreg(1, Curses.lines - 3) # Set scrollable region\n\n  chat_log = []\n  loop do\n    log_window.clear\n    log_window.box('|', '-')\n    log_window.addstr(0, 1, " Chat Log ")\n    chat_log.each_with_index { |line, index| log_window.addstr(index + 1, 1, line) }\n    log_window.refresh\n\n    input_window.attron(Curses::A_REVERSE)\n    input_window.clear\n    input_window.box('|', '-')\n    input_window.addstr(0, 1, "> ")\n    input_window.setpos(0, 3)\n\n    char = input_window.getch\n    if char == Curses::KEY_ENTER || char == 10 # Detect enter key\n      input_text = input_window.inch(0, 3).chr while !input_window.inch(0, 3).zero?\n      chat_log << "> #{input_text}"\n      chat_log.shift if chat_log.size > Curses.lines - 3\n      input_window.clear\n\n    elsif char == Curses::KEY_BACKSPACE || char == 127 # Detect backspace key\n      col = Curses.curs_col\n      input_window.delch(0, col-1) if col >= 4\n\n    elsif char.is_a?(Integer)\n      input_window.addch(char)\n\n    end\n\n    # Refresh the input window to show changes\n    input_window.refresh\n\n    break unless chat_log.size < 90_000 # Limit buffer size to prevent memory issues\n\n    Curses.doupdate\n  end\nensure\n  # Clean up curses\n  Curses.close_screen\nend