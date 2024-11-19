package com.PaymentService.utils;

public final class UrlConstraint {
    private UrlConstraint() {
    }

    public static class PaymentService {
        public static final String ROOT="/paymentService";
        public static final String CREATE="/create";
        public static final String GET_ALL="/all";
        public static final String GET_PAYMENTS_BYID="/get/{id}";
        public static final String DELETE_PAYMENT="/delete/{id}";
        public static final String EDIT_PAYMENT="/edit/{id}";

    }
    public static class Company {
        public static final String ROOT="/company";
        public static final String CREATE="/create";
        public static final String GET_ALL="/all";
        public static final String GET_COMPANY_BYID="/get/{id}";
        public static final String DELETE_COMPANY_BYID="/delete/{id}";
        public static final String EDIT_COMPANY_BYID="/edit/{id}";

    }
    public static class Users {
        public static final String ROOT="/users";
        public static final String CREATE="/create";
    }
}
