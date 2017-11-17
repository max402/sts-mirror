package de.adorsys.sts.token.tokenexchange;

import de.adorsys.sts.keymanagement.service.KeyManagementService;
import de.adorsys.sts.resourceserver.processing.ResourceServerProcessor;
import de.adorsys.sts.token.TokenCoreConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
        "de.adorsys.sts.token.tokenexchange"
})
@Import(TokenCoreConfiguration.class)
public class TokenExchangeConfiguration {

    @Bean
    public TokenExchangeService tokenExchangeService(
            ResourceServerProcessor resourceServerProcessor,
            KeyManagementService keyManagementService
    ) {
        return new TokenExchangeService(resourceServerProcessor, keyManagementService);
    }
}