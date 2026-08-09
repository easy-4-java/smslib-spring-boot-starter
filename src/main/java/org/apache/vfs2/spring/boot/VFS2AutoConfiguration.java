package org.apache.vfs2.spring.boot;

import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Auto-configuration for Apache Commons VFS2 FileSystemManager.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@Configuration
@ConditionalOnClass({ FileSystemManager.class })
@EnableConfigurationProperties(VFS2Properties.class)
public class VFS2AutoConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(VFS2AutoConfiguration.class);

	private final ApplicationContext applicationContext;

	private final VFS2Properties properties;

	public VFS2AutoConfiguration(ApplicationContext applicationContext, VFS2Properties properties) {
		this.applicationContext = applicationContext;
		this.properties = properties;
	}

	/**
	 * Creates a {@link FileSystemManager} bean using VFS.
	 *
	 * Supported URL schemes include:
	 * <ul>
	 *   <li>jar, zip, tar, gz, tgz</li>
	 *   <li>hdfs, webdav, http, https</li>
	 *   <li>ftp, ftps, sftp</li>
	 *   <li>tmp, res, ram, mime</li>
	 * </ul>
	 *
	 * @return a FileSystemManager instance
	 * @throws FileSystemException if the manager cannot be created
	 */
	@Bean
	public FileSystemManager fileSystemManager() throws FileSystemException {
		FileSystemManager fsm = VFS.getManager();
		logger.info("VFS2 FileSystemManager initialized with {} registered providers",
				fsm.getSchemes().length);
		return fsm;
	}

}
