package com.example.grpctask.mapper.impl;

import com.example.grcptask.tables.records.LogRecord;
import com.example.grpctask.mapper.BaseMapper;
import com.example.grpctask.proto.CreateLogRequest;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.JSONB;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static com.example.grcptask.Tables.LOG;


@RequiredArgsConstructor
@Component
public class BaseMapperImpl implements BaseMapper {
    private final DSLContext dslContext;

    @Override
    public LogRecord toRecord(CreateLogRequest createLogRequest) {
        if (createLogRequest == null) {
            return null;
        }

        LogRecord logRecord = dslContext.newRecord(LOG)
                .setCreatedAt(LocalDateTime.now().atZone(ZoneId.systemDefault()).toLocalDateTime())
                .setOperationService((short) createLogRequest.getOperationService())
                .setOperationType((short) createLogRequest.getOperationType())
                .setUsername(createLogRequest.getUsername())
                .setJsonData(JSONB.jsonbOrNull(createLogRequest.getJson()));

        if (createLogRequest.hasCashierCode()) { //cashier code is optional
            logRecord.setCashierCode(createLogRequest.getCashierCode());
        }

        return logRecord;
    }
}

