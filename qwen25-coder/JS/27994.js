// Example of inserting documents into a MongoDB collection using Node.js with Mongoose\n   const mongoose = require('mongoose');\n   mongoose.connect('mongodb://localhost/test', {useNewUrlParser: true, useUnifiedTopology: true});\n\n   const UserSchema = new mongoose.Schema({}, {strict: false}); // strict: false allows dynamic addition of fields\n   const User = mongoose.model('User', UserSchema);\n\n   async function addUser() {\n       const user1 = new User({ firstName: "Allain" });\n       await user1.save();\n       console.log("Saved user1", user1);\n       \n       const user2 = new User({ firstName: "Bob", lastName: "Loblaw" });\n       await user2.save();\n       console.log("Saved user2", user2);\n   }\n\n   addUser().catch(console.error).finally(() => mongoose.connection.close());