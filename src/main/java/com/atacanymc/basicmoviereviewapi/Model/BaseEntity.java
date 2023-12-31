package com.atacanymc.basicmoviereviewapi.Model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class BaseEntity {
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
