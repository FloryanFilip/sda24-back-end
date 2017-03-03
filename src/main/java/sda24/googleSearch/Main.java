package sda24.googleSearch;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        for (String s: new GoogleSearch().getLinks("Manchester",10)) {
            System.out.println(s);
        }
    }
}
