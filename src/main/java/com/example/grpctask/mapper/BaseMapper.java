package com.example.grpctask.mapper;

import com.example.grcptask.tables.records.LogRecord;
import com.example.grpctask.proto.CreateLogRequest;

public interface BaseMapper {
    LogRecord toRecord(CreateLogRequest createLogRequest);
}
