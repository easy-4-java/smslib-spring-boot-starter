package org.apache.vfs2.spring.boot;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.vfs2.FileSystemManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

/**
 * Tests for {@link VFS2AutoConfiguration}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
class VFS2AutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(VFS2AutoConfiguration.class));

    @Test
    void fileSystemManagerBeanCreated() {
        this.contextRunner.run(context -> {
            assertThat(context).hasSingleBean(FileSystemManager.class);
            assertThat(context).hasSingleBean(VFS2AutoConfiguration.class);
        });
    }

    @Test
    void propertiesLoaded() {
        this.contextRunner
                .withPropertyValues("vfs2.auto-check=true")
                .run(context -> {
                    assertThat(context).hasSingleBean(VFS2Properties.class);
                });
    }

}
