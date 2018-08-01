package com.neusoft.tools;

import java.io.File;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FileManager implements FileManagerConfig {
	private static final long serialVersionUID = 1L;
    private static TrackerClient trackerClient;
    private static TrackerServer trackerServer;
    private static StorageServer storageServer;
    private static StorageClient storageClient;

    static {
        try {
            String classPath = new File(FileManager.class.getResource("/").getFile()).getCanonicalPath();

            String fdfsClientConfigFilePath = classPath + File.separator + CLIENT_CONFIG_FILE;
            ClientGlobal.init(fdfsClientConfigFilePath);

            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();

            storageClient = new StorageClient(trackerServer, storageServer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件上传
     * 
     * @param FastDFSFile
     *            file
     * @return fileAbsolutePath
     */
    public synchronized static String upload(FastDFSFile file,NameValuePair[] valuePairs) {
        String[] uploadResults = null;
        try {
            uploadResults = storageClient.upload_file(file.getContent(),file.getExt(), valuePairs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String groupName = uploadResults[0];
        String remoteFileName = uploadResults[1];

        String fileAbsolutePath = PROTOCOL
                + TRACKER_NGNIX_ADDR
                //+ trackerServer.getInetSocketAddress().getHostName()
                + ":" + TRACKER_NGNIX_PORT 
                + SEPARATOR + groupName
                + SEPARATOR + remoteFileName;
        return fileAbsolutePath;
    }

}
