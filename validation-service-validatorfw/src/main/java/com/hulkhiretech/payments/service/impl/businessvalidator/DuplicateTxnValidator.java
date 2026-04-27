package com.hulkhiretech.payments.service.impl.businessvalidator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hulkhiretech.payments.constant.ErrorCodeEnum;
import com.hulkhiretech.payments.exception.PaymentValidationException;
import com.hulkhiretech.payments.pojo.PaymentRequest;
import com.hulkhiretech.payments.service.interfaces.BusinessValidator;

import lombok.extern.slf4j.Slf4j;

@Service("")
@Slf4j
public class DuplicateTxnValidator implements BusinessValidator {

	@Override
	public void validate(PaymentRequest paymentRequest) {
		// TODO Auto-generated method stub
		
		log.info("Executing ValidatorRule1 for paymentRequest: {}", paymentRequest);

		String firstName = paymentRequest.getUser().getFirstname();
		
		if(firstName.contains("hello")) {
			throw new PaymentValidationException(
					
					ErrorCodeEnum.FIRSTNAME_CONTAINS_HELLO.getErrorCode(),
					ErrorCodeEnum.FIRSTNAME_CONTAINS_HELLO.getErrorMessage(),
					HttpStatus.BAD_REQUEST
					
					);
		}
		
		log.info("ValidatorRule1 passed successfully for paymentRequest: {}", paymentRequest);
		
	}

}
