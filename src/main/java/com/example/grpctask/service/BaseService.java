package com.example.grpctask.service;


import com.example.grpctask.proto.CreateLogRequest;

public interface BaseService {
    void createLog(CreateLogRequest createLogRequest);
}
