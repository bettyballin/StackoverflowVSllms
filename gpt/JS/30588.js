const users = {\n  1: 'admin',\n  2: 'manager',\n  3: 'employee'\n};\n\nconst getUserRole = (userId) => {\n  return users[userId];\n};\n\nmodule.exports = { getUserRole };