// Simplified example of React using state\n   class UserForm extends React.Component {\n       constructor(props) {\n           super(props);\n           this.state = { user: { name: "John", age: 25 } };\n       }\n\n       changeName(event) {\n           this.setState({ user: {...this.state.user, name: event.target.value} });\n       }\n\n       render() {\n           return <input type="text" value={this.state.user.name} onChange={(e) => this.changeName(e)} />;\n       }\n   }