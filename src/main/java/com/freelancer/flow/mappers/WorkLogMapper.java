package com.freelancer.flow.mappers;

import com.freelancer.flow.entities.ProjectEntity;
import com.freelancer.flow.entities.WorkLogEntity;
import com.freelancer.flow.requests.WorkLogRequest;
import com.freelancer.flow.responses.WorkLogResponse;
import org.springframework.stereotype.Service;

@Service
public class WorkLogMapper {

    public WorkLogEntity toWorkLog(
            WorkLogRequest request
    ) {
        return WorkLogEntity.builder()
                .id(request.getId())
                .project(
                        ProjectEntity.builder()
                                .id(request.getProjectId())
                                .build()
                )
                .workDate(request.getWorkDate())
                .hoursWorked(request.getHoursWorked())
                .isRemote(request.getIsRemote())
                .notice(request.getNotice())
                .build();
    }

    public WorkLogResponse toWorkLogResponse(
            WorkLogEntity entity
    ) {
        return WorkLogResponse.builder()
                .id(entity.getId())
                .project(entity.getProject())
                .hoursWorked(entity.getHoursWorked())
                .workDate(entity.getWorkDate())
                .isRemote(entity.getIsRemote())
                .notice(entity.getNotice())
                .build();
    }
}
