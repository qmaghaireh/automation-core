package qualityline.automation.annotations;

import qualityline.automation.utilities.helpers.LoginSteps;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Login class.
 *
 * @author qasimmaghaireh
 * @version $Id: $Id
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Login {
  Class<? extends LoginSteps> value();
}
