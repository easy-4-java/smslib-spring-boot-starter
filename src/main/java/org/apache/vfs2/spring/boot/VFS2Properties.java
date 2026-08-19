/*
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.apache.vfs2.spring.boot;

import java.util.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(VFS2Properties.PREFIX)
/**
 * <p>Configuration properties for VFS2.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public class VFS2Properties {

    public static final String PREFIX = "vfs2";

	public static final String DEFAULT_TEMPLATE_LOADER_PATH = "classpath:/templates/";

	public static final String DEFAULT_PREFIX = "";

	public static final String DEFAULT_SUFFIX = ".httl";

	/**
	 * Well-known Beetl keys which will be passed to Beetl's  Configuration.
	 */
	private Properties settings = new Properties();

	/**
	 * Comma-separated list of template paths.
	 */
	private String[] templateLoaderPath = new String[] { DEFAULT_TEMPLATE_LOADER_PATH };

	/**
	 * Prefer file system access for template loading. File system access enables
	 * hot detection of template changes.
	 */
	private boolean preferFileSystemAccess = true;
	
	/**
	 * 是否自动检查文件是否变动
	 */
	private boolean autoCheck = false;

    /**
     * <p>Returns the settings.</p>
     * @return the get settings
     */
	public Properties getSettings() {
		return this.settings;
	}

    /**
     * <p>Sets the settings.</p>
     * @param settings
     */
	public void setSettings(Properties settings) {
		this.settings = settings;
	}

	public String[] getTemplateLoaderPath() {
		return this.templateLoaderPath;
	}

    /**
     * <p>Checks if prefer file system access.</p>
     * @return the is prefer file system access
     */
	public boolean isPreferFileSystemAccess() {
		return this.preferFileSystemAccess;
	}

    /**
     * <p>Sets the prefer file system access.</p>
     * @param preferFileSystemAccess
     */
	public void setPreferFileSystemAccess(boolean preferFileSystemAccess) {
		this.preferFileSystemAccess = preferFileSystemAccess;
	}

    /**
     * <p>Sets the template loader path.</p>
     * @param templateLoaderPaths
     */
	public void setTemplateLoaderPath(String... templateLoaderPaths) {
		this.templateLoaderPath = templateLoaderPaths;
	}

    /**
     * <p>Checks if auto check.</p>
     * @return the is auto check
     */
	public boolean isAutoCheck() {
		return autoCheck;
	}

    /**
     * <p>Sets the auto check.</p>
     * @param autoCheck
     */
	public void setAutoCheck(boolean autoCheck) {
		this.autoCheck = autoCheck;
	}

}
