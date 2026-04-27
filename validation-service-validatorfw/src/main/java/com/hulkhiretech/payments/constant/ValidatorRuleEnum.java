package com.hulkhiretech.payments.constant;

import java.util.Optional;

import com.hulkhiretech.payments.service.impl.businessvalidator.DuplicateTxnValidator;
import com.hulkhiretech.payments.service.interfaces.BusinessValidator;

/**
 * Enum mapping validator rule names to their implementing classes.
 */
public enum ValidatorRuleEnum {
    VALIDATOR_RULE1("DUPLICATE_TXN_RULE", DuplicateTxnValidator.class);


    private final String ruleName;
    private final Class<? extends BusinessValidator> validatorClass;

    ValidatorRuleEnum(String ruleName, Class<? extends BusinessValidator> validatorClass) {
        this.ruleName = ruleName;
        this.validatorClass = validatorClass;
    }

    public String getRuleName() {
        return ruleName;
    }

    public Class<? extends BusinessValidator> getValidatorClass() {
        return validatorClass;
    }

    /**
     * Return the validator class for a given rule name, or null if not found.
     */

    public static Optional<Class<? extends BusinessValidator>> getValidatorClassByRule(String ruleName) {
        if (ruleName == null) {
            return Optional.empty();
        }
        for (ValidatorRuleEnum v : ValidatorRuleEnum.values()) {
            if (v.ruleName.equals(ruleName)) {
                return Optional.of(v.getValidatorClass());
            }
        }
        return Optional.empty();
    }
    
    
}