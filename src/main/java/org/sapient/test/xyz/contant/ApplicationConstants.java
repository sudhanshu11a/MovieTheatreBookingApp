package org.sapient.test.xyz.contant;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
public final class ApplicationConstants {

    /**
     * Initialization not allowed for this constant class
     */
    private ApplicationConstants() {
        throw new IllegalStateException("Constant class");
    }

    public static final String CONTROLLER_BASE_PACKAGE = "org.sapient.test.xyz.controller";
    public static final String APPLICATION_TITLE = "XYZ Movie Booking System";
    public static final String APPLICATION_DESCRIPTION ="Api Documentation";
    public static final String APPLICATION_DOCUMENTATION_VERSION = "1.0";
    public static final String APPLICATION_TERMS_OF_SERVICE_URL = "urn:tos";
    public static final String APPLICATION_LICENSE = "Apache 2.0";
    public static final String APPLICATION_LICENSE_URL = "http://www.apache.org/licenses/LICENSE-2.0";
}
