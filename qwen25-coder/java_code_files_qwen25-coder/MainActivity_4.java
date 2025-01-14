// MainActivity.java
package com.example.myfirstapp;

// Mock Android classes to allow compilation
class Bundle {}

class R {
    public static class layout {
        public static int activity_main = 1;
    }
}

class AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {}
    void setContentView(int layoutResID) {}
}

public class MainActivity_4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

	public static void main(String[] args) {
	}
}