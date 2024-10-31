package tp.eni.enistore.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;
@Configuration
public class LocaleResolverConfig {

    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver ahl = new AcceptHeaderLocaleResolver();
        ahl.setDefaultLocale(Locale.ENGLISH);
        return ahl;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("i18n/messages");  // Le chemin de tes fichiers
        messageSource.setDefaultEncoding("UTF-8");    // Assure l'encodage UTF-8
        return messageSource;
    }


}
