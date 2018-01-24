package controller.secure;

import javafx.application.Application;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AppSecurity {

    public static final String PASSWORD = "$2a$10$PKZNn4iheYqqIgKOWUE7K.DG5Tw7E4r/139sx6k143ghYIejMK17S";

    public static boolean check(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, PASSWORD);
    }

//    public static void main(String[] args) {
//        final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String hash = "$2a$10$PKZNn4iheYqqIgKOWUE7K.DG5Tw7E4r/139sx6k143ghYIejMK17S0";

//        boolean
//        System.out.println(passwordEncoder.encode("hello"));
//    }
}
