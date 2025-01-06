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
        public static final String GET_NULL_AGE="/nullAge";
        public static final String GET_AGE_BY_GENDER_DESC="/getAgeByDESC";
        public static final String GET_STUDENTS_BY_AGE="/getStudentsByAge";
        public static final String GET_STUDENTS_GENDER_BY_IGNORECASE="/getGenderByIGNORECASE";

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
        public static final String ASSIGN_ROLE_TO_USER="/assignRoleToUser";
        public static final String EDIT_EMAIL_AND_PASSWORD="/editEmailAndPassword";
        public static final String GET_VOWEL_USERS="/getVowelUsers";

        public static final String GET_DISTINCT_USERS="/getDistinctUsers";
        public static final String GET_USERNAME_LIKE="/getUserNameLike";

    }
    public static class Roles {
        public static final String ROOT="/roles";
        public static final String CREATE="/create";
        public static final String GET_ALL_ROLE_By_UserId="/all";
        public static final String GET_ROlE_BY_ID="/get/{id}";
        public static final String DELETE_ROLE_BY_ID="/delete/{id}";
        public static final String EDIT_ROLE_BY_ID="/edit/{id}";
    }
    public static class Privilege{
        public static final String ROOT="/privilege";
        public static final String CREATE="/create";
        public static final String GET_ALL="/all";

    }
    public static class Transaction{
        public static final String ROOT="/transaction";
        public static final String CREATE="/create";
        public static final String GET_ALL="/all";
        public static final String GET_TRANSACTION_AMOUNT="/amount";
        public static final String GET_AMOUNT_BETWEEN="/getAmountBetween";
        public static final String GET_MIN_MAX_AMOUNT="/getMinMaxAmount";
    public static final String GET_AMOUNT_BETWEEN_MIN_MAX="/getAmountBetweenMinMax";

    }
    public static class Balance{
        public static final String ROOT="/balance";
        public static final String CREATE="/create";

    }

    }
