package com.company.sqlduolingo.entity.template;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class EntityListener {

    @PrePersist
    public void setCreatedAt(AbsEntity entity) {
        entity.setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void setUpdatedAt(AbsEntity entity) {
        entity.setUpdatedAt(LocalDateTime.now());
    }

    @PreRemove
    public void setDeletedAt(AbsEntity entity) {
        entity.setDeletedAt(LocalDateTime.now());
    }

}