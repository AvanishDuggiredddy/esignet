/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package io.mosip.idp.core.validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
public class OIDCPromptValidator implements ConstraintValidator<OIDCPrompt, String> {

    @Value("#{${mosip.idp.supported.ui.prompts}}")
    private List<String> supportedPrompts;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null)
            return true; // As this is OPTIONAL parameter

        return supportedPrompts.contains(value);
    }
}
