import java.util.Set;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

public class ValidatorConfig {

    public LocalValidatorFactoryBean validator(MessageSource messageSource) {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        // Set the Spring's MessageSource for Hibernate Validator
        factoryBean.setValidationMessageSource(messageSource);
        return factoryBean;
    }

    public static void main(String[] args) {
        // Example of setting up MessageSource
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:validationMessages");
        messageSource.setDefaultEncoding("UTF-8");

        LocalValidatorFactoryBean validatorFactoryBean = new ValidatorConfig().validator(messageSource);
        // Use validatorFactoryBean to obtain your validator
    }
}