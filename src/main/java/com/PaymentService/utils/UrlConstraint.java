package com.PaymentService.utils;

public final class UrlConstraint {
    private UrlConstraint() {
    }

    public static class PaymentService {
        public static final String ROOT="/paymentService";
        public static final String CREATE="/create";
        public static final String GET_ALL="/all";
        public static final String GET_PAYMENTS_BY_ID ="/get/{id}";
        public static final String DELETE_PAYMENT="/delete/{id}";
        public static final String EDIT_PAYMENT="/edit/{id}";

    }
    public static class Company {
        public static final String ROOT="/company";
        public static final String CREATE="/create";
        public static final String GET_ALL="/all";
        public static final String GET_COMPANY_BY_ID ="/get/{id}";
        public static final String DELETE_COMPANY_BY_ID ="/delete/{id}";
        public static final String EDIT_COMPANY_BY_ID ="/edit/{id}";

    }
    public static class Users {
        public static final String ROOT="/users";
        public static final String CREATE="/create";
        public static final String GET_ALL="/all";
        public static final String GET_USER_BY_ID ="/get/{id}";
        public static final String DELETE_USER_BY_ID ="/delete/{id}";
        public static final String EDIT_USER_BY_ID ="/edit/{id}";
    }
    public static class Roles {
        public static final String ROOT="/roles";
        public static final String CREATE="/create";
        public static final String GET_ALL_By_UserId="/all";
    }
    public static class Privilege{
        public static final String ROOT="/privilege";
        public static final String CREATE="/create";
        public static final String GET_ALL="/all";
    }

    }
