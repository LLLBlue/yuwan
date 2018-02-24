package com.blue.yw.constants;

public final class Constants {
    private Constants() {

    }

    public static final String LOGIN_ERROR = "000666";

    public final static class UserResultCode {
        public static final String SUCCESS = "00";
        public static final String ERROR = "01";
        public static final String PASSWORD_ERROR = "09";

    }

    public final static class VoteResultCode {
        public static final String VOTE = "01";
        public static final String NO_VOTE = "00";
    }

}
