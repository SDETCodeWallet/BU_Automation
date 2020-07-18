package com.automation.constants;

/**
 * Version 1.1
 * 
 * @author shubham
 *
 */
public class GlobalConstants {

	private final static String userDir = System.getProperty("user.dir");
	public final static String EXTENTREPORT_PATH = userDir + "//ExecutionResults//ExtentReportResults.html";
	public static final String resourcesPath = userDir + "//src/test/resources//";

	/**
	 * To configure the browser type
	 * 
	 * @author Shubham
	 *
	 */
	public enum BrowserType {
		Firefox, IE, Chrome
	}

	public enum HttpMethodType {
		GET, POST, DELETE, UPDATE, PATCH, OPTIONS
	}

	public enum keys {
		ENTER, SPACE, TAB, CTRL, SHIFT, F1, ALT;
	}

	/**
	 * To get the API http method type
	 * 
	 * @author shubham
	 *
	 */
	public enum LocatorType {
		ID, XPATH, LINKTEXT, PARTIALLINKTEXT, CSS, NAME, TAGNAME
	}

	public static class ApiConstants {

		/**
		 * 1XX status codes
		 */

		public static final int CONTINUE = 100;
		public static final int SWITCHING_PROTOCOLS = 101;
		public static final int PROCESSING = 102;

		/**
		 * 2XX status codes
		 */
		public static final int HTTP_OK = 200;
		public static final int CREATED = 201;
		public static final int ACCEPTED = 202;
		public static final int NON_AUTHORITATIVE_INFORMATION = 203;
		public static final int NO_CONTENT = 204;
		public static final int RESET_CONTENT = 205;
		public static final int PARTIAL_CONTENT = 206;
		public static final int MULTISTATUS = 207;
		public static final int ALREADY_REOPORTED = 208;
		public static final int IM_USED = 226;

		/**
		 * 3XX status codes
		 */
		public static final int MULTIPLE_CHOICE = 300;
		public static final int MOVED_PERMANENTLY = 301;
		public static final int FOUND = 302;
		public static final int SEE_OTHER = 303;
		public static final int NOT_MODIFIED = 304;
		public static final int USE_PROXY = 305;
		public static final int UNUSED = 306;
		public static final int TEMPORARY_REDIRECT = 307;
		public static final int PERMANENT_REDIRECT = 308;

		/**
		 * 4XX status codes
		 */

		public static final int BAD_REQUEST = 400;
		public static final int UNAUTHORIZED = 401;
		public static final int PAYMENT_REQUIRED = 402;
		public static final int FORBIDDEN = 403;
		public static final int NOT_FOUND = 404;
		public static final int METHOD_NOT_ALLOWED = 405;
		public static final int NOT_ACCEPTABLE = 406;
		public static final int PROXY_AUTHENTICATION_REQUIRED = 407;
		public static final int REQUEST_TIMEOUT = 408;
		public static final int CONFLICT = 409;
		public static final int GONE = 410;
		public static final int LENGTH_REQUIRED = 411;
		public static final int PRECONDITION_FAILED = 412;
		public static final int REQUEST_ENTITY_TOO_LARGE = 413;
		public static final int REQUEST_URI_TOO_LONG = 414;
		public static final int UNSUPPORTED_MEDIA_TYPE = 415;
		public static final int REQUESTED_RANGE_NOT_SATISFIABLE = 416;
		public static final int EXPECTATION_FAILED = 417;
		public static final int IM_A_TEAPOT = 418;
		public static final int ENHANCE_YOUR_CALM = 420;
		public static final int UNPROCESSABLE_ENTITY = 422;
		public static final int LOCKED = 423;
		public static final int FAILED_DEPENDENCY = 424;
		public static final int RESERVED_FOR_WEBDAV = 425;
		public static final int UPGRADE_REQUIRED = 426;
		public static final int PRECONDITION_REQUIRED = 428;
		public static final int TOO_MANY_REQUESTS = 429;
		public static final int REQUEST_HEADER_FIELDS_TOO_LARGE = 431;
		public static final int NO_RESPONSE = 444;
		public static final int RETRY_WITH = 449;
		public static final int BLOCKE_BY_WINDOWS_PARENTAL_CONTROLS = 450;
		public static final int UNAVAILABLE_FOR_LEGAL_REASONS = 451;
		public static final int CLIENT_CLOSED_REQUEST = 499;

		/**
		 * 5XX status codes
		 */

		public static final int INTERNAL_SERVER_ERROR = 500;
		public static final int NOT_IMPLEMENTED = 501;
		public static final int BAD_GATEWAY = 502;
		public static final int SERVICE_UNAVAILABLE = 503;
		public static final int GATEWAY_TIMEOUT = 504;
		public static final int HTTP_VERSION_NOT_SUPPORTED = 505;
		public static final int VARIANT_ALSO_NEGOTIATES = 506;
		public static final int INSUFFICIENT_STORAGE = 507;
		public static final int LOOP_DETECTED = 508;
		public static final int BANDWIDTH_LIMIT_EXCEEDED = 509;
		public static final int NOT_EXTENDED = 510;
		public static final int NETWORK_AUTHENTICATION_REQUIRED = 511;
		public static final int NETWORK_READ_TIMEOUT_ERROR = 598;
		public static final int NETWORK_CONNECT_TIMEOUT_ERROR = 599;

		public static final String GETALLEMPLOYEE = "/employees";
		public static final String GETEMPLOYEEDETAILS = "/employee";
		public static final String CREATEUSER = "/create";
		public static final String CREATEUSERJSONBODY = userDir + "/src/test/resources/testdata/createUser.json";

	}

	public static class WebConstants {
		public static final String webResource = userDir + "//src/test/resources/WebResource/";
		public static final String xmlWebLocators = userDir + "//src/test/resources/WebResource/Locators/XMLLocators//";
		public static final String propertiesWebLocators = userDir
				+ "//src/test/resources/WebResource/Locators/PropertiesLocators//";
		public static final String excelLocators = userDir
				+ "//src/test/resources/WebResource/Locators//ExcelLocators/";

	}

}
