package com.blue.yw.constants;

public final class Constants {
    private Constants() {

    }

    public static final String LOGIN_ERROR = "000666";
    public static final String SWITCH_ON = "1";
    public static final String SWITCH_OFF = "0";

    public final static class ConfigGuideKey {
        public static final String NOMINATION_TIME = "NOMINATION_TIME";
        public static final String VOTE_TIME = "VOTE_TIME";
        public static final String NOMINATION_TITLE = "NOMINATION_TITLE";
        public static final String VOTE_TITLE = "VOTE_TITLE";
        public static final String HOME_NOTICE = "HOME_NOTICE";

    }

    public final static class UserResultCode {
        public static final String SUCCESS = "00";
        public static final String ERROR = "01";
        public static final String PASSWORD_ERROR = "09";

    }

    public final static class VoteResultCode {
        public static final String VOTE = "01";
        public static final String NO_VOTE = "00";
        public static final String TIME_OUT = "02";
    }

}
