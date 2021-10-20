package com.github.martynfunclub.trackingsystem.services;

import com.github.martynfunclub.trackingsystem.dto.CredentialsDto;

public interface ChangesService {
    void createChange(CredentialsDto credentialsDto);
}
