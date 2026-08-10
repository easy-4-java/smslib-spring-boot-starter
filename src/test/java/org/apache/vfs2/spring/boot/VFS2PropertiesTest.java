package org.apache.vfs2.spring.boot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Properties;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link VFS2Properties}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
class VFS2PropertiesTest {

    @Test
    void defaultValues() {
        VFS2Properties props = new VFS2Properties();
        assertThat(props.getSettings()).isNotNull();
        assertThat(props.getSettings()).isEmpty();
        assertThat(props.getTemplateLoaderPath()).containsExactly(VFS2Properties.DEFAULT_TEMPLATE_LOADER_PATH);
        assertThat(props.isPreferFileSystemAccess()).isTrue();
        assertThat(props.isAutoCheck()).isFalse();
    }

    @Test
    void constants() {
        assertThat(VFS2Properties.DEFAULT_TEMPLATE_LOADER_PATH).isEqualTo("classpath:/templates/");
        assertThat(VFS2Properties.DEFAULT_PREFIX).isEqualTo("");
        assertThat(VFS2Properties.DEFAULT_SUFFIX).isEqualTo(".httl");
    }

    @Test
    void setSettings() {
        VFS2Properties props = new VFS2Properties();
        Properties settings = new Properties();
        settings.setProperty("key1", "value1");
        props.setSettings(settings);
        assertThat(props.getSettings()).containsEntry("key1", "value1");
    }

    @Test
    void setTemplateLoaderPath() {
        VFS2Properties props = new VFS2Properties();
        props.setTemplateLoaderPath("/custom/path");
        assertThat(props.getTemplateLoaderPath()).containsExactly("/custom/path");
    }

    @Test
    void setPreferFileSystemAccess() {
        VFS2Properties props = new VFS2Properties();
        props.setPreferFileSystemAccess(false);
        assertThat(props.isPreferFileSystemAccess()).isFalse();
    }

    @Test
    void setAutoCheck() {
        VFS2Properties props = new VFS2Properties();
        props.setAutoCheck(true);
        assertThat(props.isAutoCheck()).isTrue();
    }

}
