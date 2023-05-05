package com.example.grpctask.service.impl;

import com.example.grcptask.tables.records.LogRecord;
import com.example.grpctask.mapper.BaseMapper;
import com.example.grpctask.proto.CreateLogRequest;
import com.example.grpctask.repository.BaseRepository;
import com.example.grpctask.service.BaseService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Service
public class BaseServiceImpl implements BaseService {
    BaseRepository baseRepository;
    BaseMapper baseMapper;

    @Override
    public void createLog(CreateLogRequest createLogRequest) {
        LogRecord logRecord = baseMapper.toRecord(createLogRequest);
        baseRepository.addLog(logRecord);
    }
}
