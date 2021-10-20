package com.github.martynfunclub.trackingsystem.services;

import com.github.martynfunclub.trackingsystem.dto.CredentialsDto;
import com.github.martynfunclub.trackingsystem.models.Worker;

public interface WorkerService {

    Worker getWorkerByCreds(CredentialsDto credentialsDto);
}
