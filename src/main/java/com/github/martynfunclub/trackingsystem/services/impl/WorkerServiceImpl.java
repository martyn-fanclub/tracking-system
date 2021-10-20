package com.github.martynfunclub.trackingsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.martynfunclub.trackingsystem.dao.WorkerRepository;
import com.github.martynfunclub.trackingsystem.dto.CredentialsDto;
import com.github.martynfunclub.trackingsystem.models.Worker;
import com.github.martynfunclub.trackingsystem.services.WorkerService;

@Service
public class WorkerServiceImpl implements WorkerService, UserDetailsService {
    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public Worker getWorkerByCreds(CredentialsDto credentialsDto) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Worker worker = workerRepository.findById()
    }
}
