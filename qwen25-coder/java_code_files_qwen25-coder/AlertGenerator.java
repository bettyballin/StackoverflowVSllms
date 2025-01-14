package com.cg.mock;

import java.util.ArrayList;

public class AlertGenerator {

    public static ArrayList<Alert> getAlert() {
        ArrayList<Alert> alt = new ArrayList<Alert>();

        alt.add(new Alert("alert1_1", "alert2_1", "alert3_1"));
        alt.add(new Alert("alert1_2", "alert2_2", "alert3_2"));
        alt.add(new Alert("alert1_3", "alert2_3", "alert3_3"));

        return alt;
    }

    public static void main(String[] args) {
    }
}

class Alert {
    private String s1;
    private String s2;
    private String s3;

    public Alert(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }
}