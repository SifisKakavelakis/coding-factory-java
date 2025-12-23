package gr.aueb.cf.cf9.ch17.enums;

import gr.aueb.cf.cf9.ch11.User;

public class Main {

    public static void main(String[] args) {
        UserRole role = UserRole.ADMIN;

        String roleAdmin = role.name();         // ADMIN
        System.out.println("Role: " + roleAdmin + " , ordinal: " + role.ordinal());

        UserRole roleUser = UserRole.valueOf(roleAdmin);

        for (UserRole r : UserRole.values()) {
            System.out.println(r.ordinal() + ", " + r.name());
        }
    }
}
