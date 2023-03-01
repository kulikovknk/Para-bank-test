package config;

public class Config {

    // ParaBank REST API
    private static final String PARA_BANK_BASE_URI = "http://parabank.parasoft.com";
    private static final String PARA_BANK_BASE_PATH = "/parabank/services/bank";
    private static final String API_GET_ACCOUNT = "/accounts/{accountId}";
    private static final String API_GET_LOGIN = "/login/{username}/{password}";
    private static final String API_GET_CUSTOMER_DETAILS = "/customers/{customerId}";
    private static final String API_GET_CUSTOMER_ACCOUNTS = "/customers/{customerId}/accounts";
    private static final String API_POST_CUSTOMER_UPDATE = "/customers/update/{customerId}";


    // ParaBank web pages
    private static final String PARA_BANK_MAIN_PAGE = "https://parabank.parasoft.com/parabank/index.htm";
    private static final String PARA_BANK_REGISTER_PAGE = "https://parabank.parasoft.com/parabank/register.htm";

    public static String getBaseUri() {
        return PARA_BANK_BASE_URI;
    }

    public static String getBasePath() {
        return PARA_BANK_BASE_PATH;
    }

    public static String getMainPage() {
        return PARA_BANK_MAIN_PAGE;
    }

    public static String getRegisterPage() {
        return PARA_BANK_REGISTER_PAGE;
    }

    public static String getAPIGetAccount() {
        return API_GET_ACCOUNT;
    }

    public static String getAPIGetLogin() {
        return API_GET_LOGIN;
    }

    public static String getAPIGetCustomerDetails() {
        return API_GET_CUSTOMER_DETAILS;
    }

    public static String getAPIGetCustomerAccounts() {
        return API_GET_CUSTOMER_ACCOUNTS;
    }
    public static String getApiPostCustomerUpdate() {
        return API_POST_CUSTOMER_UPDATE;
    }
}
