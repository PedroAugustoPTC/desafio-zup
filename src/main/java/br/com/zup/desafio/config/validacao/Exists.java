package br.com.zup.desafio.config.validacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = ExistsValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Exists {

	String message() default "Valor não existe no banco.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String campo();

	Class<?> classe();
}
