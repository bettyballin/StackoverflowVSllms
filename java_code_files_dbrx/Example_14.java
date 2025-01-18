public class Example {
    public static void main(String[] args) {
        MyBean1 myBean1 = new MyBean1();
        myBean1.setId(123);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.getSession().setAttribute("bean1", myBean1); //store myBean1 into the session object as "bean1" attribute

        //Then you can get this bean instance anywhere in your web application:
        MyBean1 gotBean = (MyBean1) request.getSession().getAttribute("bean1");
    }

    static class MyBean1 {
        private int id;
        public void setId(int id) {
            this.id = id;
        }
    }

    static class MockHttpServletRequest {
        private MockHttpSession session = new MockHttpSession();
        public MockHttpSession getSession() {
            return session;
        }
    }

    static class MockHttpSession {
        private java.util.Map<String, Object> attributes = new java.util.HashMap<>();
        public void setAttribute(String name, Object value) {
            attributes.put(name, value);
        }
        public Object getAttribute(String name) {
            return attributes.get(name);
        }
    }
}