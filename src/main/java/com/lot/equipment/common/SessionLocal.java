package com.lot.equipment.common;

public class SessionLocal {

    private static ThreadLocal<Principal> local = new ThreadLocal<Principal>();

    public static void setPrincipal(Principal principal) {
        local.set(principal);
    }

    public static Principal getPrincipal() {
        return local.get();
    }
}
