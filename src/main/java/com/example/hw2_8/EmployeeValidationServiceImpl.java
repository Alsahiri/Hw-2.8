package com.example.hw2_8;

import com.example.hw2_8.exception.InvalidEmployeeDataException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeeValidationServiceImpl implements EmployeeValidationService {
    @Override
    public void validate(String firstName, String lastName) {
        validation(firstName);
        validation(lastName);
    }

    private void validation(String name) {
        if (!StringUtils.isAlpha(name)) {
            throw new InvalidEmployeeDataException();
        }
    }

}
