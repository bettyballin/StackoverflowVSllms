class SessionWrapper\n  def initialize(session, key)\n    @session = session\n    @key = key\n  end\n\n  def [](key)\n    @session[@key][key]\n  end\n\n  def []=(key, value)\n    @session[@key][key] = value\n  end\nend\n\nsession = { 'user_123' => { 'name' => 'Alice', 'age' => 30 } }\ncurrent_app = { uid: 'user_123' }\n\n@app_session = SessionWrapper.new(session, current_app[:uid])\n\n# Accessing values\nputs @app_session['name'] # Outputs: Alice\n\n# Modifying values\n@app_session['age'] = 31\nputs session['user_123']['age'] # Outputs: 31