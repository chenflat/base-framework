package io.github.supercube.config.apidoc;

import com.fasterxml.classmate.TypeResolver;
import io.github.supercube.test.LogbackRecorder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.plugin.core.SimplePluginRegistry;
import springfox.documentation.schema.JacksonEnumTypeDeterminer;
import springfox.documentation.schema.TypeNameExtractor;
import springfox.documentation.spi.schema.TypeNameProviderPlugin;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SwaggerPluginsAutoConfigurationTest {

    private SwaggerPluginsAutoConfiguration.SpringPagePluginConfiguration pagePluginConfig;
    private LogbackRecorder recorder;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        pagePluginConfig = new SwaggerPluginsAutoConfiguration.SpringPagePluginConfiguration();

        recorder = LogbackRecorder.forClass(SwaggerAutoConfiguration.class).reset().capture("ALL");
    }

    @AfterEach
    public void teardown() {
        recorder.release();
    }

    @Test
    public void testPageableParameterBuilderPlugin() {
        TypeResolver resolver = new TypeResolver();
        List<TypeNameProviderPlugin> plugins = new LinkedList<>();
        TypeNameExtractor extractor = new TypeNameExtractor(resolver, SimplePluginRegistry.create(plugins), new JacksonEnumTypeDeterminer());
        PageableParameterBuilderPlugin plugin = pagePluginConfig.pageableParameterBuilderPlugin(extractor, resolver);
        assertThat(plugin.getResolver()).isEqualTo(resolver);
        assertThat(plugin.getNameExtractor()).isEqualTo(extractor);
    }
}
