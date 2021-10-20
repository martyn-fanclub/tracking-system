package com.github.martynfunclub.trackingsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.martynfunclub.trackingsystem.dto.CredentialsDto;
import com.github.martynfunclub.trackingsystem.models.Worker;
import com.github.martynfunclub.trackingsystem.services.ChangesService;
import com.github.martynfunclub.trackingsystem.services.WorkerService;

@Service
public class ChangesServiceImpl implements ChangesService {
    private final WorkerService workerService;

    @Autowired
    public ChangesServiceImpl(WorkerService workerService) {
        this.workerService = workerService;
    }

    @Override
    public void createChange(CredentialsDto credentialsDto) {
        Worker worker = workerService.getWorkerByCreds(credentialsDto);
    }
}
