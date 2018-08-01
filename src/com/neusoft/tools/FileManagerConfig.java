package com.neusoft.tools;

import java.io.Serializable;

public interface FileManagerConfig extends Serializable {
	public static final String FILE_DEFAULT_AUTHOR = "skye";

    public static final String PROTOCOL = "http://";

    public static final String SEPARATOR = "/";

    public static final String TRACKER_NGNIX_ADDR = "101.201.70.204";

    public static final String TRACKER_NGNIX_PORT = "9998";

    public static final String CLIENT_CONFIG_FILE = "fdfs_client.conf";

}
