package io.github.supercube.security.uaa;

import io.github.supercube.config.FrameworkProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

/**
 * <p>UaaAutoConfiguration class.</p>
 */
@Configuration
@ConditionalOnClass({ClientCredentialsResourceDetails.class, LoadBalancerClient.class})
@ConditionalOnProperty("framework.security.client-authorization.client-id")
public class UaaAutoConfiguration {

    private FrameworkProperties frameworkProperties;

    /**
     * <p>Constructor for UaaAutoConfiguration.</p>
     *
     * @param frameworkProperties a {@link FrameworkProperties} object.
     */
    public UaaAutoConfiguration(FrameworkProperties frameworkProperties) {
        this.frameworkProperties = frameworkProperties;
    }

    /**
     * <p>loadBalancedResourceDetails.</p>
     *
     * @param loadBalancerClient a {@link org.springframework.cloud.client.loadbalancer.LoadBalancerClient} object.
     * @return a {@link io.github.supercube.security.uaa.LoadBalancedResourceDetails} object.
     */
    @Bean
    public LoadBalancedResourceDetails loadBalancedResourceDetails(LoadBalancerClient loadBalancerClient) {
        LoadBalancedResourceDetails loadBalancedResourceDetails = new LoadBalancedResourceDetails(loadBalancerClient);
        FrameworkProperties.Security.ClientAuthorization clientAuthorization = frameworkProperties.getSecurity()
            .getClientAuthorization();
        loadBalancedResourceDetails.setAccessTokenUri(clientAuthorization.getAccessTokenUri());
        loadBalancedResourceDetails.setTokenServiceId(clientAuthorization.getTokenServiceId());
        loadBalancedResourceDetails.setClientId(clientAuthorization.getClientId());
        loadBalancedResourceDetails.setClientSecret(clientAuthorization.getClientSecret());
        return loadBalancedResourceDetails;
    }
}
