package com.weligama.roomservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "room")
public class RoomEntity {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomName;
    private String facilities;
    private String numberOfPax;
    private String floorNo;
    private Long rate;
}
